package asteroid4;

import asteroid1.iBullet;

public class MasterBullet implements iBullet {

	public MasterBullet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String SetVelocityMagnitude() {
		// TODO Auto-generated method stub
		return "20";
	}

	@Override
	public String SetMaxLifeSpan() {
		// TODO Auto-generated method stub
		return "120";
	}

}