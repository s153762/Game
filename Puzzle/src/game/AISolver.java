package game;

public class AISolver {
	private int emptyX,emptyY,tempX,tempY,targetX,targetY;
	private int[][] gameGrid;
	private Model model;
	
	public AISolver(Model model){
		emptyY = model.getY();
		emptyX = model.getX();
		targetX = -1;
		targetY = 0;
		this.model = model;
		this.gameGrid = model.getGameGrid();
		
	}
	
	
	public void solve(){
		int tempnumber = 0;
		while(!model.checkWinCondition()){
			tempnumber++;
			findNumber(tempnumber);
			findNextTarget();
			movetoTemp();

		}
	}
	
	public void findNumber(int targetNumber){
		for(int i = 0; i<model.getN();i++){
			for(int j = 0;j<model.getN();j++){
				if(gameGrid[i][j] == targetNumber)
				{
					tempX = j;
					tempY = i;
					i = model.getN();
					j = model.getN();
				}
			}
		}
	}
	
	public void findNextTarget(){
		targetX++;
		if(targetX> model.getN()-1){
			targetX = 0;
			targetY++;
		}
	}
	
	public void move(int direction)	{
		// move temp 0: left, 1: right, 2: up, 3: down;
		switch(direction){
		case 0:
			if(tempY != model.getN()-1){
				model.updateArray(model.getY(), emptyX, model.getY()+1, model.getX());
				model.updateArray(model.getY(), model.getX(), model.getY(), model.getX()-1);
				model.updateArray(model.getY(), model.getX(), model.getY(), model.getX()-1);
				model.updateArray(model.getY(), model.getX(), model.getY()-1, model.getX());
				model.updateArray(model.getY(), model.getX(), model.getY(), model.getX()+1);
			} else {
				model.updateArray(model.getY(), emptyX, model.getY()-1, model.getX());
				model.updateArray(model.getY(), model.getX(), model.getY(), model.getX()-1);
				model.updateArray(model.getY(), model.getX(), model.getY(), model.getX()-1);
				model.updateArray(model.getY(), model.getX(), model.getY()+1, model.getX());
				model.updateArray(model.getY(), model.getX(), model.getY(), model.getX()+1);	
			}

			
			break;
		case 1:
			if(tempY != model.getN()-1){
				model.updateArray(model.getY(), emptyX, model.getY()+1, model.getX());
				model.updateArray(model.getY(), model.getX(), model.getY(), model.getX()+1);
				model.updateArray(model.getY(), model.getX(), model.getY(), model.getX()+1);
				model.updateArray(model.getY(), model.getX(), model.getY()-1, model.getX());
				model.updateArray(model.getY(), model.getX(), model.getY(), model.getX()-1);
			} else {
				model.updateArray(model.getY(), emptyX, model.getY()-1, model.getX());
				model.updateArray(model.getY(), model.getX(), model.getY(), model.getX()+1);
				model.updateArray(model.getY(), model.getX(), model.getY(), model.getX()+1);
				model.updateArray(model.getY(), model.getX(), model.getY()+1, model.getX());
				model.updateArray(model.getY(), model.getX(), model.getY(), model.getX()-1);	
			}
			break;
		case 2:
			model.updateArray(model.getY(), emptyX, model.getY(), model.getX()+1);
			model.updateArray(model.getY(), model.getX(), model.getY()-1, model.getX());
			model.updateArray(model.getY(), model.getX(), model.getY()-1, model.getX());
			model.updateArray(model.getY(), model.getX(), model.getY(), model.getX()-1);
			model.updateArray(model.getY(), model.getX(), model.getY()+1, model.getX());
			
			break;
		case 3: 
			model.updateArray(model.getY(), emptyX, model.getY(), model.getX()+1);
			model.updateArray(model.getY(), model.getX(), model.getY()+1, model.getX());
			model.updateArray(model.getY(), model.getX(), model.getY()+1, model.getX());
			model.updateArray(model.getY(), model.getX(), model.getY(), model.getX()-1);
			model.updateArray(model.getY(), model.getX(), model.getY()-1, model.getX());
			break;
		}		
	}
	
	public void movetoTemp(){
		if(targetX < tempX  ){
			if(tempY == model.getY() && (tempX>model.getX())){
				
				for(int i = 0; i>Math.abs(model.getX()-tempX) ; i++){
					model.updateArray(model.getY(), model.getX(), model.getY(), model.getX()+1);
				}
				tempX--;
			}
			else{
				for(int i = 1; i>Math.abs(model.getX()-tempX) ; i++){
					model.updateArray(model.getY(), model.getX(), model.getY(), model.getX()-1);
				}
			}
		}
		else if(targetX > tempX){
			if(tempY == model.getY() && (tempX<model.getX())){
				
				for(int i = 0; i>Math.abs(model.getX()-tempX) ; i++){
					model.updateArray(model.getY(), model.getX(), model.getY(), model.getX()-1);
					
				}
				tempX++;
			}
			else{
				for(int i = 1; i>Math.abs(model.getX()-tempX) ; i++){
					model.updateArray(model.getY(), model.getX(), model.getY(), model.getX()+1);
				}
			}
			
		}
		if(targetY < tempY  ){
			if(tempX == model.getX() && (tempY>model.getY())){
				
				for(int i = 0; i>Math.abs(model.getY()-tempY) ; i++){
					model.updateArray(model.getY(), model.getX(), model.getY()+1, model.getX());
					
				}
				tempX--;
			}
			else{
				for(int i = 1; i>Math.abs(model.getY()-tempY) ; i++){
					model.updateArray(model.getY(), model.getX(), model.getY()-1, model.getX());
				}
			}
			
		}
		else if(targetY > tempY){
			if(tempX == model.getX() && (tempY<model.getY())){
				
				for(int i = 0; i>Math.abs(model.getY()-tempY) ; i++){
					model.updateArray(model.getY(), model.getX(), model.getY()-1, model.getX());
					
				}
				tempY++;
			}
			else{
				for(int i = 1; i>Math.abs(model.getY()-tempY) ; i++){
					model.updateArray(model.getY(), model.getX(), model.getY()+1, model.getX());
				}
			}
			
		}
	}
	

}
