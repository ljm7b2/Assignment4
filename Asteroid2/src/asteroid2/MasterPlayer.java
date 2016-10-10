package asteroid2;

import asteroid1.iPlayer;

public class MasterPlayer implements iPlayer {

	public MasterPlayer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String SetMaxVelocity() {
		return "7.1";
	}

	@Override
	public String SetRotationSpeed() {
		return "0.09";
	}

	@Override
	public String SetMaxBullets() {
		return "120";
	}

	@Override
	public String SetFireRate() {
		return "1";
	}

}
