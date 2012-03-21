package com.savefish.physics.resolve;

/********************************
 * Description: 该类创建物理世界
 * Author     : 王志伟
 * Date       : 2012/03/13
 *******************************/

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.JointDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.DistanceJointDef;
import com.badlogic.gdx.physics.box2d.joints.FrictionJointDef;
import com.badlogic.gdx.physics.box2d.joints.GearJointDef;
import com.badlogic.gdx.physics.box2d.joints.MouseJointDef;
import com.badlogic.gdx.physics.box2d.joints.PrismaticJointDef;
import com.badlogic.gdx.physics.box2d.joints.PulleyJointDef;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;
import com.badlogic.gdx.physics.box2d.joints.RopeJointDef;
import com.badlogic.gdx.physics.box2d.joints.WeldJointDef;
import com.badlogic.gdx.physics.box2d.joints.WheelJointDef;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GreenWorldFactory {

	/**
	 * @description 创建物理世界world
	 * @param path
	 *            json地图文件路径
	 * @return
	 */
	public static World creatWorld(String path) {
		GreenWorld gw = createGreenWorld(path);

		Vector2 gravity = gw.gravity.toVector2();
		World world = new World(gravity, false);
		world.setAutoClearForces(gw.autoClearForces);
		world.setContinuousPhysics(gw.continuousPhysics);
		world.setWarmStarting(gw.warmStarting);

		ArrayList<Body> bodies = new ArrayList<Body>();
		ArrayList<Joint> joints = new ArrayList<Joint>();

		addBody(bodies, gw, world);
		addJoint(bodies, joints, gw, world);
		return world;
	}

	/**
	 * @description 创建一个GreenWorld
	 * @param path
	 *            json地图文件路径
	 * @return
	 */
	private static GreenWorld createGreenWorld(String path) {
		Logger logger = Logger.getAnonymousLogger();
		if ((null == path) || path.equals(""))
			return null;
		logger.log(Level.INFO, path);

		String mapText = Gdx.files.internal(path).readString();
		String jsonWorld = standardizeMap(mapText);

		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(GreenHexFloat.class,
				new GreenHexFloatDeserializer());
		builder.registerTypeAdapter(GreenVector2.class,
				new GreenVector2Deserializer());
		Gson gson = builder.create();
		GreenWorld greenWorld = gson.fromJson(jsonWorld, GreenWorld.class);

		return greenWorld;
	}

	/**
	 * @description 规范化地图命名
	 * @param raw
	 * @return
	 */
	private static String standardizeMap(String raw) {
		String jsonWorld = raw.replaceAll("massData-I", "massData_I")
				.replace("massData-center", "massData_center")
				.replace("massData-mass", "massData_mass")
				.replace("filter-categoryBits", "filter_categoryBits")
				.replace("filter-maskBits", "filter_maskBits")
				.replace("filter-groupIndex", "filter_groupIndex");
		return jsonWorld;
	}

	/**
	 * @description 添加 bodies
	 * @param bodies
	 * @param gw
	 * @param world
	 */
	private static void addBody(ArrayList<Body> bodies, GreenWorld gw,
			World world) {
		// 添加Body
		for (GreenBody b : gw.body) {
			bodies.add(createBody(b, world));
		}
	}

	/**
	 * @description 创建BodyDef
	 * @param gb
	 * @param world
	 * @return
	 */
	private static BodyDef createBodyDef(GreenBody gb, World world) {
		BodyDef bd = new BodyDef();

		bd.position.set(gb.position.toVector2());
		if (null != gb.angle)
			bd.angle = gb.angle.toFloat();
		if (null != gb.angularVelocity)
			bd.angularVelocity = gb.angularVelocity.toFloat();
		if (null != gb.angularDamping)
			bd.angularDamping = gb.angularDamping.toFloat();
		if (null != gb.linearVelocity)
			bd.linearVelocity.set(gb.linearVelocity.toVector2());
		if (null != gb.linearDamping)
			bd.linearDamping = gb.linearDamping.toFloat();
		if (null != gb.gravityScale)
			bd.gravityScale = gb.gravityScale.toFloat();

		bd.allowSleep = gb.allowSleep;
		bd.active = gb.active;
		bd.bullet = gb.bullet;
		bd.fixedRotation = gb.fixedRotation;
		bd.awake = gb.awake;

		if (1 == gb.type)
			bd.type = BodyDef.BodyType.StaticBody;
		if (2 == gb.type)
			bd.type = BodyDef.BodyType.DynamicBody;
		if (3 == gb.type)
			bd.type = BodyDef.BodyType.KinematicBody;

		return bd;
	}

	/**
	 * @description 创建Body
	 * @param gb
	 * @param world
	 * @return
	 */
	private static Body createBody(GreenBody gb, World world) {
		Body body = world.createBody(createBodyDef(gb, world));
		if (null != gb.name)
			body.setUserData(gb.name);
		createFixture(gb, body);
		return body;
	}

	/**
	 * @description 创建夹具
	 * @param gb
	 * @param body
	 * @return
	 */
	private static Fixture createFixture(GreenBody gb, Body body) {
		if (null != gb.fixture) {
			// 添加Fixture
			for (GreenFixture gf : gb.fixture) {
				FixtureDef fDef = new FixtureDef();
				if (gf.restitution != null)
					fDef.restitution = gf.restitution.toFloat();
				if (gf.friction != null)
					fDef.friction = gf.friction.toFloat();
				if (gf.density != null)
					fDef.density = gf.density.toFloat();
				fDef.isSensor = gf.sensor;
				fDef.filter.maskBits = (short) gf.filter_maskBits;
				fDef.filter.categoryBits = (short) gf.filter_categoryBits;
				fDef.filter.groupIndex = (short) gf.filter_groupIndex;
				Shape shape = null;
				if (gf.circle != null) {
					CircleShape circle = new CircleShape();
					shape = circle;
					circle.setRadius(gf.circle.radius.toFloat());
					circle.setPosition(gf.circle.center.toVector2());
				} else if (gf.edge != null) {
					EdgeShape edge = new EdgeShape();
					shape = edge;
					edge.set(gf.edge.vertex1.toVector2(),
							gf.edge.vertex2.toVector2());
					if (gf.edge.hasVertex0) {
					}
					if (gf.edge.hasVertex3) {

					}
				} else if (gf.loop != null) {
					// 跳过
				} else if (gf.chain != null) {
					ChainShape chain = new ChainShape();
					shape = chain;
					int size = gf.chain.vertices.x.size();
					Vector2 vertices[] = new Vector2[size];
					for (int i = 0; i < size; ++i) {
						vertices[i] = new Vector2(gf.chain.vertices.x.get(i)
								.toFloat(), gf.chain.vertices.y.get(i)
								.toFloat());
					}
					chain.createChain(vertices);
					if (gf.chain.hasPrevVertex)
						chain.setPrevVertex(gf.chain.prevVertex.toVector2());
					if (gf.chain.hasNextVertex)
						chain.setNextVertex(gf.chain.nextVertex.toVector2());
				} else if (gf.polygon != null) {
					PolygonShape polygon = new PolygonShape();
					shape = polygon;
					int size = gf.polygon.vertices.x.size();
					Vector2 vertices[] = new Vector2[size];
					for (int i = 0; i < size; ++i) {
						vertices[i] = new Vector2(gf.polygon.vertices.x.get(i)
								.toFloat(), gf.polygon.vertices.y.get(i)
								.toFloat());
					}
					polygon.set(vertices);
				}
				if (shape != null) {
					fDef.shape = shape;
					Fixture fixture = body.createFixture(fDef);
					if (gf.name != null)
						fixture.setUserData(gf.name);
				} else {
				}
			}
		}
		return null;
	}

	/**
	 * @description 添加 Joints
	 * @param bodies
	 * @param joints
	 * @param gw
	 * @param world
	 */
	private static void addJoint(ArrayList<Body> bodies,
			ArrayList<Joint> joints, GreenWorld gw, World world) {
		if (gw.body != null && gw.joint != null) {
			for (GreenJoint def : gw.joint) {
				if (def.type != "gear")
					createJoint(def, bodies, joints, world);
			}
			for (GreenJoint def : gw.joint) {
				if (def.type == "gear")
					createJoint(def, bodies, joints, world);
			}
		}
	}

	/**
	 * @description 创建关节joint
	 * @param gd
	 * @param bodys
	 * @param joints
	 * @param world
	 * @return
	 */
	private static Joint createJoint(GreenJoint gd, ArrayList<Body> bodys,
			ArrayList<Joint> joints, World world) {
		int bodyIndexA = gd.bodyA;
		int bodyIndexB = gd.bodyB;
		int bodySize = bodys.size();
		if (bodyIndexA > bodySize || bodyIndexB > bodySize) {
			return null;
		}
		Joint joint = null;
		JointDef jd = createJointDef(gd, joints);
		if (null != jd) {
			jd.bodyA = bodys.get(bodyIndexA);
			jd.bodyB = bodys.get(bodyIndexB);
			jd.collideConnected = gd.collideConnected;
			joint = world.createJoint(jd);
			joints.add(joint);
		}
		return joint;
	}

	/**
	 * @description 创建关节皮肤JointDef
	 * @param gd
	 * @param joints
	 * @return
	 */
	private static JointDef createJointDef(GreenJoint gd,
			ArrayList<Joint> joints) {
		JointDef jd = null;
		if (gd.type.equals("revolute")) {
			RevoluteJointDef revoluteDef = new RevoluteJointDef();
			revoluteDef.localAnchorA.set(gd.anchorA.toVector2());
			revoluteDef.localAnchorB.set(gd.anchorB.toVector2());
			revoluteDef.referenceAngle = gd.refAngle.toFloat();
			revoluteDef.enableLimit = gd.enableLimit;
			revoluteDef.lowerAngle = gd.lowerLimit.toFloat();
			revoluteDef.upperAngle = gd.upperLimit.toFloat();
			revoluteDef.enableMotor = gd.enableMotor;
			revoluteDef.motorSpeed = gd.motorSpeed.toFloat();
			revoluteDef.maxMotorTorque = gd.maxMotorTorque.toFloat();
			jd = revoluteDef;
		} else if (gd.type.equals("prismatic")) {
			PrismaticJointDef prismaticDef = new PrismaticJointDef();
			prismaticDef.localAnchorA.set(gd.anchorA.toVector2());
			prismaticDef.localAnchorB.set(gd.anchorB.toVector2());
			if (gd.localAxisA != null)
				prismaticDef.localAxisA.set(gd.localAxisA.toVector2());
			else
				prismaticDef.localAxisA.set(gd.localAxis1.toVector2());
			prismaticDef.referenceAngle = gd.refAngle.toFloat();
			prismaticDef.enableLimit = gd.enableLimit;
			prismaticDef.lowerTranslation = gd.lowerLimit.toFloat();
			prismaticDef.upperTranslation = gd.upperLimit.toFloat();
			prismaticDef.enableMotor = gd.enableMotor;
			prismaticDef.motorSpeed = gd.motorSpeed.toFloat();
			prismaticDef.maxMotorForce = gd.maxMotorForce.toFloat();
			jd = prismaticDef;
		} else if (gd.type.equals("distance")) {
			DistanceJointDef distanceDef = new DistanceJointDef();
			distanceDef.localAnchorA.set(gd.anchorA.toVector2());
			distanceDef.localAnchorB.set(gd.anchorB.toVector2());
			distanceDef.length = gd.length.toFloat();
			distanceDef.frequencyHz = gd.frequency.toFloat();
			distanceDef.dampingRatio = gd.dampingRatio.toFloat();
			jd = distanceDef;
		} else if (gd.type.equals("pulley")) {
			PulleyJointDef pulleyDef = new PulleyJointDef();
			pulleyDef.groundAnchorA.set(gd.groundAnchorA.toVector2());
			pulleyDef.groundAnchorB.set(gd.groundAnchorB.toVector2());
			pulleyDef.localAnchorA.set(gd.anchorA.toVector2());
			pulleyDef.localAnchorB.set(gd.anchorB.toVector2());
			pulleyDef.lengthA = gd.lengthA.toFloat();
			pulleyDef.lengthB = gd.lengthB.toFloat();
			pulleyDef.ratio = gd.ratio.toFloat();
			jd = pulleyDef;
		} else if (gd.type.equals("mouse")) {
			MouseJointDef mouseDef = new MouseJointDef();
			mouseDef.target.set(gd.target.toVector2());
			mouseDef.maxForce = gd.maxForce.toFloat();
			mouseDef.frequencyHz = gd.frequency.toFloat();
			mouseDef.dampingRatio = gd.dampingRatio.toFloat();
			jd = mouseDef;
		} else if (gd.type.equals("gear")) {
			GearJointDef gearDef = new GearJointDef();
			int jointIndex1 = gd.joint1;
			int jointIndex2 = gd.joint2;
			gearDef.joint1 = joints.get(jointIndex1);
			gearDef.joint2 = joints.get(jointIndex2);
			gearDef.ratio = gd.ratio.toFloat();
		} else if (gd.type.equals("wheel")) {
			WheelJointDef wheelDef = new WheelJointDef();
			wheelDef.localAnchorA.set(gd.anchorA.toVector2());
			wheelDef.localAnchorB.set(gd.anchorB.toVector2());
			wheelDef.localAxisA.set(gd.localAxisA.toVector2());
			wheelDef.enableMotor = gd.enableMotor;
			wheelDef.motorSpeed = gd.motorSpeed.toFloat();
			wheelDef.maxMotorTorque = gd.maxMotorTorque.toFloat();
			wheelDef.frequencyHz = gd.springFrequency.toFloat();
			wheelDef.dampingRatio = gd.springDampingRatio.toFloat();
			jd = wheelDef;
		} else if (gd.type.equals("weld")) {
			WeldJointDef weldDef = new WeldJointDef();
			weldDef.localAnchorA.set(gd.anchorA.toVector2());
			weldDef.localAnchorB.set(gd.anchorB.toVector2());
			weldDef.referenceAngle = 0;
			jd = weldDef;
		} else if (gd.type.equals("friction")) {
			FrictionJointDef frictionDef = new FrictionJointDef();
			frictionDef.localAnchorA.set(gd.anchorA.toVector2());
			frictionDef.localAnchorB.set(gd.anchorB.toVector2());
			frictionDef.maxForce = gd.maxForce.toFloat();
			frictionDef.maxTorque = gd.maxTorque.toFloat();
			jd = frictionDef;
		} else if (gd.type.equals("rope")) {
			RopeJointDef ropeDef = new RopeJointDef();
			ropeDef.localAnchorA.set(gd.anchorA.toVector2());
			ropeDef.localAnchorB.set(gd.anchorB.toVector2());
			ropeDef.maxLength = gd.maxLength.toFloat();
			jd = ropeDef;
		}
		return jd;
	}
}
