
public class enemyType1 extends EnemyGUI{  //enemy type1:move around in an area, go back when touch Obstructs

	private boolean canLeft = true;		
	private boolean canRight = true;
	private boolean onLand = false;
	private boolean isLeft = true;
	private boolean isALive;
	//Thread t = new Thread();
	
	@Override
	public void move() {
		if (this.getEnemyXCoord() >= getRightMax()) {
			isLeft = true;
		}
		if (this.getEnemyXCoord() <= getLeftMax()) {
			isLeft = false;
		}
		
		if (isLeft == true) {
			setXCoord(getEnemyXCoord()-1);
		}
		if (isLeft == false) {
			setXCoord(getEnemyXCoord()+1);
		}
	}
		
		public enemyType1(World newWorld,int enemyXCoord,int enemyYCoord,boolean isLeft,int leftMax,int rightMax) {
			super(newWorld,enemyXCoord,enemyYCoord);
			this.isLeft = isLeft;
			setLeftMax(leftMax);
			setRightMax(rightMax);
			isALive = true;
			
			//size
			
			/*
			t.start();
			t.suspend();
			*/
		}
		
		public enemyType1(enemyType1 toCopy) {
			super(toCopy.getWorld(), toCopy.getEnemyXCoord(), toCopy.getEnemyYCoord());
			this.isLeft = toCopy.isLeft;
			setLeftMax(toCopy.getLeftMax());
			setRightMax(toCopy.getRightMax());
		}
		
		//while (true) {
		//javafx shape
		//move speed
		/*
		for (int i = 0; i < getAllObstruction().size(); i++) {
			Obstrution ob = getAllObstruction().get(i);
			// cannot move left
			if (ob.getX() == ob size < this.y && ob size > this.y)) {
				canRight = false;
			}
			// cannot move right
			if (ob.getX() ==    < this.y &&   > this.y)) {
				canLeft = false;
			}
				
			//turn back if touch Obstruct
			if (this.isLeft && !canLeft || this.x == 0) { 
				this.isLeft = false;
			} else if (this.isLeft && !canRight || this.x == 840) {
				this.isLeft = true;
			}
			
			
				try {
					Thread.sleep(80);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
	*/
	/*
	@Override
	public void run() {
		move();
	}
	*/

}
