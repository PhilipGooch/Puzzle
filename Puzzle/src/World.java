import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class World extends JPanel implements ActionListener{
	
	public static void main(String a []){
		
		JFrame j = new JFrame();
		World w = new World();
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setSize(455, 425);
		j.setVisible(true);
		j.setResizable(false);
		j.setLocationRelativeTo(null);
		j.add(w);
	}
	
	Timer t;
	int size = 50;
	int xtab = 50;
	int ytab = 50;
	boolean squares [][] = new boolean [6][6];	
	ArrayList<Block> blocks = new ArrayList<Block>();
	Block add;
	int savex;
	int savey;
	int x;
	int y;
	int s = 100;
	int savegridx;
	int savegridy;
	int gap;
	boolean complete;
	boolean stop;
	int savei;
	int top = -1000;
	int bottom = 1000;
	int left = -1000;
	int right = 1000;
	int lr = 100;
	double test = 25;
	boolean oob;
	int count;
	int refreshx = 389;
	int refreshy = 105;
	int level;
	int selectionx = 364;
	int selectiony = 75;
	int backx [] = {selectionx, selectionx + 20, selectionx + 20};
	int backy [] = {selectiony + 10, selectiony, selectiony + 20};
	int forwardx [] = {selectionx + 50, selectionx + 70, selectionx + 50};
	int forwardy [] = {selectiony, selectiony + 10, selectiony + 20};
	Font f = new Font("Sherif", Font.BOLD, 22);
	int pause;
	int cap = 1;
	int memx;
	int memy;
	ArrayList<Integer> memory = new ArrayList<Integer>();
	ArrayList<Integer> memoryx = new ArrayList<Integer>();
	ArrayList<Integer> memoryy = new ArrayList<Integer>();
	int last = 100;
	int undox = 389;
	int undoy = 275;
	int undoarrowx [] = {undox - 2, undox + 8, undox + 3};
	int undoarrowy [] = {undoy + 10, undoy + 10, undoy + 16};
	int movecounter;

	public World(){
		t = new Timer(5, this);
		t.start();
		addMouseListener(new ML());
		addMouseMotionListener(new ML());
		level1();
	}
	
	public void level1(){
		level = 1;
		newblock(3, 0, 0, 0, false);
		newblock(3, 1, 5, 0, false);
		newblock(3, 1, 2, 1, false);
		newblock(2, 0, 0, 2, true);
		newblock(2, 1, 0, 3, false);
		newblock(2, 0, 4, 3, false);
		newblock(2, 1, 4, 4, false);
		newblock(3, 0, 0, 5, false);
	}
	
	public void level2(){
		level = 2;
		newblock(2, 1, 2, 1, false);
		newblock(3, 1, 3, 1, false);
		newblock(3, 1, 4, 1, false);
		newblock(2, 0, 0, 2, true);
		newblock(2, 0, 0, 3, false);
		newblock(2, 1, 2, 3, false);
		newblock(2, 1, 1, 4, false);
		newblock(2, 0, 2, 5, false);
	}
	
	public void level3(){
		level = 3;
		newblock(2, 1, 0, 0, false);
		newblock(2, 0, 1, 0, false);
		newblock(2, 0, 3, 0, false);
		newblock(2, 1, 2, 1, false);
		newblock(2, 0, 0, 2, true);
		newblock(3, 1, 3, 2, false);
		newblock(3, 1, 4, 2, false);
		newblock(3, 0, 0, 4, false);
	}
	
	public void level4(){
		level = 4;
		newblock(3, 1, 3, 1, false);
		newblock(3, 1, 4, 1, false);
		newblock(2, 1, 5, 1, false);
		newblock(2, 0, 0, 2, true);
		newblock(2, 0, 0, 3, false);
		newblock(2, 1, 1, 4, false);
		newblock(2, 0, 2, 4, false);
		newblock(2, 0, 2, 5, false);
	}
	
	public void level5(){
		level = 5;
		newblock(3, 1, 2, 0, false);
		newblock(2, 0, 4, 0, false);
		newblock(3, 1, 5, 1, false);
		newblock(2, 0, 0, 2, true);
		newblock(2, 1, 1, 3, false);
		newblock(3, 0, 2, 3, false);
		newblock(2, 0, 2, 4, false);
		newblock(2, 1, 4, 4, false);
	}
	
	public void level6(){
		level = 6;
		newblock(3, 1, 2, 0, false);
		newblock(3, 1, 3, 0, false);
		newblock(2, 0, 4, 0, false);
		newblock(2, 1, 4, 1, false);
		newblock(2, 0, 0, 2, true);
		newblock(2, 1, 1, 3, false);
		newblock(2, 1, 4, 3, false);
		newblock(2, 0, 2, 4, false);
	}
	
	public void level7(){
		level = 7;
		newblock(2, 1, 0, 0, false);
		newblock(2, 1, 3, 0, false);
		newblock(2, 0, 0, 2, true);
		newblock(2, 1, 3, 2, false);
		newblock(3, 1, 5, 2, false);
		newblock(3, 0, 0, 3, false);
		newblock(2, 1, 1, 4, false);
		newblock(2, 0, 2, 4, false);
		newblock(2, 0, 2, 5, false);
	}
	
	public void level8(){
		level = 8;
		newblock(3, 0, 1, 1, false);
		newblock(2, 1, 5, 1, false);
		newblock(2, 0, 0, 2, true);
		newblock(2, 1, 2, 2, false);
		newblock(3, 1, 3, 2, false);
		newblock(2, 0, 4, 3, false);
		newblock(3, 0, 0, 4, false);
		newblock(2, 1, 5, 4, false);
	}
	
	public void level9(){
		level = 9;
		newblock(3, 0, 0, 0, false);
		newblock(3, 1, 3, 0, false);
		newblock(3, 1, 0, 1, false);
		newblock(2, 0, 1, 1, false);
		newblock(2, 0, 4, 1, false);
		newblock(2, 0, 1, 2, true);
		newblock(3, 1, 5, 2, false);
		newblock(2, 1, 2, 3, false);
		newblock(2, 0, 3, 3, false);
		newblock(2, 1, 4, 4, false);
		newblock(3, 0, 0, 5, false);
	}
	
	public void level10(){
		level = 10;
		newblock(2, 1, 0, 0, false);
		newblock(3, 0, 1, 0, false);
		newblock(3, 0, 1, 1, false);
		newblock(3, 1, 4, 1, false);
		newblock(3, 1, 1, 2, false);
		newblock(2, 0, 2, 2, true);
		newblock(2, 0, 2, 3, false);
		newblock(2, 1, 3, 4, false);
		newblock(2, 0, 4, 4, false);
		newblock(3, 0, 0, 5, false);
	}
	
	public void newblock(int s, int hv, int x, int y, boolean m){
		add = new Block(s, hv, x, y, m);
		blocks.add(add);
		for(int i = 0; i < add.size; i++){
			if(add.hv == 0){
				squares[add.x + i][add.y] = true;
			}
			else if(add.hv == 1){
				squares[add.x][add.y + i] = true;
			}
		}
	}
	
	public void refresh(){
		blocks.clear();
		memory.clear();
		memoryx.clear();
		memoryy.clear();
		movecounter = 0;
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				squares[i][j] = false;
			}
		}
		if(level == 1){
			level1();
		}
		else if(level == 2){
			level2();
		}
		else if(level == 3){
			level3();
		}
		else if(level == 4){
			level4();
		}
		else if(level == 5){
			level5();
		}
		else if(level == 6){
			level6();
		}
		else if(level == 7){
			level7();
		}
		else if(level == 8){
			level8();
		}
		else if(level == 9){
			level9();
		}
		else if(level == 10){
			level10();
		}
	}
	
	private class ML implements MouseListener, MouseMotionListener{
		public void mouseClicked(MouseEvent e){}
		public void mouseDragged(MouseEvent e){
			x = e.getX();
			y = e.getY();
		}
		public void mouseMoved(MouseEvent e){}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		public void mousePressed(MouseEvent e){
			x = e.getX();
			y = e.getY();
			savex = e.getX();
			savey = e.getY();
			selected(x, y);
			if(x >= refreshx && x <= refreshx + 20 && y >= refreshy && y <= refreshy + 20){
				refresh();
			}
			else if(level > 1 && x >= selectionx && x <= selectionx + 20 && y >= selectiony && y <= selectiony + 20){
				level--;
				refresh();
			}
			else if(level < 10 && level < cap && x >= selectionx + 50 && x <= selectionx + 70 && y >= selectiony && y <= selectiony + 20){
				level++;
				refresh();
			}
			else if(memory.size() > 0 && x >= undox && x <= undox + 20 && y >= undoy && y <= undoy + 20){				
				movecounter--;
				if(blocks.get(memory.get(memory.size() - 1)).hv == 0 && blocks.get(memory.get(memory.size() - 1)).size == 2){
					squares[blocks.get(memory.get(memory.size() - 1)).x][blocks.get(memory.get(memory.size() - 1)).y] = false;
					squares[blocks.get(memory.get(memory.size() - 1)).x + 1][blocks.get(memory.get(memory.size() - 1)).y] = false;
					squares[memoryx.get(memoryx.size() - 1)][memoryy.get(memoryy.size() - 1)] = true;
					squares[memoryx.get(memoryx.size() - 1) + 1][memoryy.get(memoryy.size() - 1)] = true;
				}
				else if(blocks.get(memory.get(memory.size() - 1)).hv == 0 && blocks.get(memory.get(memory.size() - 1)).size == 3){
					squares[blocks.get(memory.get(memory.size() - 1)).x][blocks.get(memory.get(memory.size() - 1)).y] = false;
					squares[blocks.get(memory.get(memory.size() - 1)).x + 1][blocks.get(memory.get(memory.size() - 1)).y] = false;
					squares[blocks.get(memory.get(memory.size() - 1)).x + 2][blocks.get(memory.get(memory.size() - 1)).y] = false;
					squares[memoryx.get(memoryx.size() - 1)][memoryy.get(memoryy.size() - 1)] = true;
					squares[memoryx.get(memoryx.size() - 1) + 1][memoryy.get(memoryy.size() - 1)] = true;
					squares[memoryx.get(memoryx.size() - 1) + 2][memoryy.get(memoryy.size() - 1)] = true;
				}
				else if(blocks.get(memory.get(memory.size() - 1)).hv == 1 && blocks.get(memory.get(memory.size() - 1)).size == 2){
					squares[blocks.get(memory.get(memory.size() - 1)).x][blocks.get(memory.get(memory.size() - 1)).y] = false;
					squares[blocks.get(memory.get(memory.size() - 1)).x][blocks.get(memory.get(memory.size() - 1)).y + 1] = false;
					squares[memoryx.get(memoryx.size() - 1)][memoryy.get(memoryy.size() - 1)] = true;
					squares[memoryx.get(memoryx.size() - 1)][memoryy.get(memoryy.size() - 1) + 1] = true;
				}
				else if(blocks.get(memory.get(memory.size() - 1)).hv == 1 && blocks.get(memory.get(memory.size() - 1)).size == 3){
					squares[blocks.get(memory.get(memory.size() - 1)).x][blocks.get(memory.get(memory.size() - 1)).y] = false;
					squares[blocks.get(memory.get(memory.size() - 1)).x][blocks.get(memory.get(memory.size() - 1)).y + 1] = false;
					squares[blocks.get(memory.get(memory.size() - 1)).x][blocks.get(memory.get(memory.size() - 1)).y + 2] = false;
					squares[memoryx.get(memoryx.size() - 1)][memoryy.get(memoryy.size() - 1)] = true;
					squares[memoryx.get(memoryx.size() - 1)][memoryy.get(memoryy.size() - 1) + 1] = true;
					squares[memoryx.get(memoryx.size() - 1)][memoryy.get(memoryy.size() - 1) + 2] = true;
				}
				blocks.get(memory.get(memory.size() - 1)).x = memoryx.get(memoryx.size() - 1);
				blocks.get(memory.get(memory.size() - 1)).y = memoryy.get(memoryy.size() - 1);
				memory.remove(memory.size() - 1);
				memoryx.remove(memoryx.size() - 1);
				memoryy.remove(memoryy.size() - 1);

			}
		}
		public void mouseReleased(MouseEvent e){
			if(!complete && s < 100 && blocks.get(s).hv == 0){
				for(int i = 4; i >= 1; i--){
					if(savex - x > i * size - test){
						if(blocks.get(s).x >= i){
							check(0, 0, savegridx - 1, blocks.get(s).y);
							if(gap > 0 && i <= gap){
								memx = blocks.get(s).x;
								memy = blocks.get(s).y;
								memory.add(s);
								memoryx.add(memx);
								memoryy.add(memy);
								blocks.get(s).x -= i;
								update(0, blocks.get(s).size);
								movecounter++;
								break;
							}
						}
					}
					else if(savex - x < i * size * - 1 + test){
						if(blocks.get(s).x <= i + blocks.get(s).size){
							check(0, 1, savegridx + blocks.get(s).size, blocks.get(s).y);	
							if(gap > 0 && i <= gap){
								memx = blocks.get(s).x;
								memy = blocks.get(s).y;
								memory.add(s);
								memoryx.add(memx);
								memoryy.add(memy);
								blocks.get(s).x += i;
								update(0, blocks.get(s).size);
								movecounter++;
								break;
							}	
						}
					}
				}
			}
			else if(!complete && s < 100 && blocks.get(s).hv == 1){
				for(int i = 4; i >= 1; i--){
					if(savey - y > i * size - test){
						if(blocks.get(s).y >= i){
							check(1, 0, blocks.get(s).x, savegridy - 1);
							if(gap > 0 && i <= gap){
								memx = blocks.get(s).x;
								memy = blocks.get(s).y;
								memory.add(s);
								memoryx.add(memx);
								memoryy.add(memy);
								blocks.get(s).y -= i;
								update(1, blocks.get(s).size);
								movecounter++;
								break;
							}
						}
					}
					else if(savey - y < i * size * - 1 + test){
						if(blocks.get(s).y <= i + blocks.get(s).size){
							check(1, 1, blocks.get(s).x, savegridy + blocks.get(s).size);
							if(gap > 0 && i <= gap){
								memx = blocks.get(s).x;
								memy = blocks.get(s).y;
								memory.add(s);
								memoryx.add(memx);
								memoryy.add(memy);
								blocks.get(s).y += i;
								update(1, blocks.get(s).size);
								movecounter++;
								break;
							}
						}
					}
				}
			}
			for(int i = 0; i < blocks.size(); i++){
				blocks.get(i).selected = false;
			}
			if(s < 100 && blocks.get(s).main){
				if(blocks.get(s).x == 4 && blocks.get(s).y == 2){
					complete = true;
				}
			}
			s = 100;
			gap = 0;	
			top = -1000;
			bottom = 1000;
			left = -1000;
			right = 1000;
			lr = 100;
			stop = false;
		}
	}

	public void check(int hv, int lr, int xx, int yy){
		if(hv == 0 && lr == 0){
			do{
				if(!squares[xx - gap][yy]){
					gap++;
				}
				else{
					break;
				}
			}while(xx - gap >= 0);
		}
		else if(hv == 0 && lr == 1){
			do{
				if(xx + gap < 6 && !squares[xx + gap][yy]){
					gap++;
				}
				else{
					break;
				}
			}while(xx + gap < 6);
		}
		else if(hv == 1 && lr == 0){
			do{
				if(!squares[xx][yy - gap]){
					gap++;
				}
				else{
					break;
				}
			}while(yy - gap >= 0);
		}
		else if(hv == 1 && lr == 1){
			do{
				if(yy + gap < 6 && !squares[xx][yy + gap]){
					gap++;
				}
				else{
					break;
				}
			}while(yy + gap < 6);
		}
	}
	
	public void update(int hv, int ss){
		if(hv == 0 && ss == 2){
			squares[savegridx][savegridy] = false;
			squares[savegridx + 1][savegridy] = false;
			squares[blocks.get(s).x][blocks.get(s).y] = true;
			squares[blocks.get(s).x + 1][blocks.get(s).y] = true;
		}
		else if(hv == 0 && ss == 3){
			squares[savegridx][savegridy] = false;
			squares[savegridx + 1][savegridy] = false;
			squares[savegridx + 2][savegridy] = false;
			squares[blocks.get(s).x][blocks.get(s).y] = true;
			squares[blocks.get(s).x + 1][blocks.get(s).y] = true;
			squares[blocks.get(s).x + 2][blocks.get(s).y] = true;
		}
		else if(hv == 1 && ss == 2){
			squares[savegridx][savegridy] = false;
			squares[savegridx][savegridy + 1] = false;
			squares[blocks.get(s).x][blocks.get(s).y] = true;
			squares[blocks.get(s).x][blocks.get(s).y + 1] = true;
		}
		else if(hv == 1 && ss == 3){
			squares[savegridx][savegridy] = false;
			squares[savegridx][savegridy + 1] = false;
			squares[savegridx][savegridy + 2] = false;
			squares[blocks.get(s).x][blocks.get(s).y] = true;
			squares[blocks.get(s).x][blocks.get(s).y + 1] = true;
			squares[blocks.get(s).x][blocks.get(s).y + 2] = true;
		}
	}
	
	public void selected(int xx, int yy){
		for(int i = 0; i < blocks.size(); i++){
			if((blocks.get(i).hv == 0 && xx > xtab + blocks.get(i).x * size && xx < xtab + blocks.get(i).x * size + size * blocks.get(i).size &&
				yy > ytab + blocks.get(i).y * size && yy < ytab + blocks.get(i).y * size + size) ||
				(blocks.get(i).hv == 1 && xx > xtab + blocks.get(i).x * size && xx < xtab + blocks.get(i).x * size + size &&
				yy > ytab + blocks.get(i).y * size && yy < ytab + blocks.get(i).y * size + size * blocks.get(i).size)){
				blocks.get(i).selected = true;
				s = i;
				savegridx = blocks.get(i).x;
				savegridy = blocks.get(i).y;
				break;
			}
		}
	}
	
	public void actionPerformed(ActionEvent e){
		if(complete){
			pause++;
			if(pause >= 200){
				complete = false;
				level++;
				cap++;
				refresh();
				pause = 0;
			}
		}
		if(s < 100){
			if(blocks.get(s).hv == 1){
				if(ytab + blocks.get(s).y * size - (savey - y) < ytab){
					oob = true;
					if(!stop){
						savei = 0;
					}
				}
				else if(ytab + (blocks.get(s).y + blocks.get(s).size) * size - (savey - y) > ytab + (6 * size)){
					oob = true;
					if(!stop){
						savei = 6 - blocks.get(s).size;
					}
				}
				else{
					oob = false;
				}
			}
			else if(blocks.get(s).hv == 0){
				if(xtab + blocks.get(s).x * size - (savex - x) < xtab){
					oob = true;
					if(!stop){
						savei = 0;
					}
				}
				else if(!blocks.get(s).main && xtab + (blocks.get(s).x + blocks.get(s).size) * size - (savex - x) > xtab + (6 * size)){
					oob = true;
					if(!stop){
						savei = 6 - blocks.get(s).size;
					}
				}
				else if(blocks.get(s).main && xtab + (blocks.get(s).x + blocks.get(s).size) * size - (savex - x) > xtab + (7 * size)){
					oob = true;
					if(!stop){
						savei = 6 - blocks.get(s).size;
					}
				}
				else{
					oob = false;
				}
			}
		}
		repaint();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		setBackground(Color.DARK_GRAY);
		g.setColor(Color.BLACK);
		g.drawRect(xtab - 1, ytab - 1, size * 6 + 2, size * 6 + 2);
		g.drawRect(xtab + size * 6 + 1, ytab + size * 2 - 2, size, size + 4);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(xtab, ytab, size * 6 + 1, size * 6 + 1);
		g.fillRect(xtab + size * 6 + 1, ytab + size * 2 - 1, size, size + 3);
		for(int i = 0; i < blocks.size(); i++){
			if(i != s){
				if(blocks.get(i).hv == 0){
					if(blocks.get(i).main){
						if(complete){
							g.setColor(Color.RED);
							g.fillRect(xtab + 5 * size + 3, ytab + blocks.get(i).y * size + 3, blocks.get(i).size * size - 5, size - 5);	
							g.setColor(Color.BLACK);
							g.drawRect(xtab + 5 * size + 2, ytab + blocks.get(i).y * size + 2, blocks.get(i).size * size - 4, size - 4);
						}
					}
					else{
						g.setColor(Color.ORANGE);
						g.fillRect(xtab + blocks.get(i).x * size + 3, ytab + blocks.get(i).y * size + 3, blocks.get(i).size * size - 5, size - 5);
						g.setColor(Color.BLACK);
						g.drawRect(xtab + blocks.get(i).x * size + 2, ytab + blocks.get(i).y * size + 2, blocks.get(i).size * size - 4, size - 4);
					
					}
					if(!complete && blocks.get(i).main){
						g.setColor(Color.RED);
						g.fillRect(xtab + blocks.get(i).x * size + 3, ytab + blocks.get(i).y * size + 3, blocks.get(i).size * size - 5, size - 5);
						g.setColor(Color.BLACK);
						g.drawRect(xtab + blocks.get(i).x * size + 2, ytab + blocks.get(i).y * size + 2, blocks.get(i).size * size - 4, size - 4);
					}
				}
				else if(blocks.get(i).hv == 1){
					g.setColor(Color.ORANGE);
					g.fillRect(xtab + blocks.get(i).x * size + 3, ytab + blocks.get(i).y * size + 3, size - 5, blocks.get(i).size * size - 5);
					g.setColor(Color.BLACK);
					g.drawRect(xtab + blocks.get(i).x * size + 2, ytab + blocks.get(i).y * size + 2, size - 4, blocks.get(i).size * size - 4);
				}
			}
		}
		
		if(s < 100 && blocks.get(s).hv == 0){
			for(int i = 0; i < 6; i++){
				if((blocks.get(s).size == 2 && i != blocks.get(s).x && i != blocks.get(s).x + 1) ||
					(blocks.get(s).size == 3 && i != blocks.get(s).x && i != blocks.get(s).x + 1 && i != blocks.get(s).x + 2)){
					if(squares[i][blocks.get(s).y]){
						if((xtab + blocks.get(s).x * size - (savex - x) > xtab + i * size && xtab + blocks.get(s).x * size - (savex - x) < xtab + i * size + size) ||
							(xtab + (blocks.get(s).x + blocks.get(s).size) * size - (savex - x) > xtab + i * size && xtab + (blocks.get(s).x + blocks.get(s).size) * size - (savex - x) < xtab + i * size + size)){
							if(!stop){
								stop = true;
								if(blocks.get(s).x > i){
									savei = i + 1;
									lr = 0;
									if(left == -1000){
										left = x;
									}
								}
								else{
									savei = i - blocks.get(s).size;
									lr = 1;
									if(right == 1000){
										right = x;
									}
								}
								break;
							}
						}
						else{
							if((lr == 0 && x > left) || (lr == 1 && x < right)){
								stop = false;
							}
						}
					}
				}
			}
			if(stop || oob){
				if(blocks.get(s).main){
					if(savei == 6 - blocks.get(s).size){
						g.setColor(Color.RED);
						g.fillRect(xtab + 5 * size + 3, ytab + blocks.get(s).y * size + 3, blocks.get(s).size * size - 5, size - 5);
						g.setColor(Color.BLACK);
						g.drawRect(xtab + 5 * size + 2, ytab + blocks.get(s).y * size + 2, blocks.get(s).size * size - 4, size - 4);
					}
					else{
						g.setColor(Color.RED);
						g.fillRect(xtab + savei * size + 3, ytab + blocks.get(s).y * size + 3, blocks.get(s).size * size - 5, size - 5);
						g.setColor(Color.BLACK);
						g.drawRect(xtab + savei * size + 2, ytab + blocks.get(s).y * size + 2, blocks.get(s).size * size - 4, size - 4);
					}
				}
				else if(!blocks.get(s).main){
					g.setColor(Color.ORANGE);
					g.fillRect(xtab + savei * size + 3, ytab + blocks.get(s).y * size + 3, blocks.get(s).size * size - 5, size - 5);
					g.setColor(Color.BLACK);
					g.drawRect(xtab + savei * size + 2, ytab + blocks.get(s).y * size + 2, blocks.get(s).size * size - 4, size - 4);
				}
			}
			else if(!oob && !stop){
				if(blocks.get(s).main){
					g.setColor(Color.RED);
				}
				else{
					g.setColor(Color.ORANGE);
				}
				g.fillRect(xtab + blocks.get(s).x * size - (savex - x) + 3, ytab + blocks.get(s).y * size + 3, blocks.get(s).size * size - 5, size - 5);
				g.setColor(Color.BLACK);
				g.drawRect(xtab + blocks.get(s).x * size - (savex - x) + 2, ytab + blocks.get(s).y * size + 2, blocks.get(s).size * size - 4, size - 4);
			}
		}
		else if(s < 100 && blocks.get(s).hv == 1){
			for(int i = 0; i < 6; i++){
				if((blocks.get(s).size == 2 && i != blocks.get(s).y && i != blocks.get(s).y + 1) ||
					(blocks.get(s).size == 3 && i != blocks.get(s).y && i != blocks.get(s).y + 1 && i != blocks.get(s).y + 2)){
					if(squares[blocks.get(s).x][i]){
						if((ytab + blocks.get(s).y * size - (savey - y) > ytab + i * size && ytab + blocks.get(s).y * size - (savey - y) < ytab + i * size + size) ||
							(ytab + (blocks.get(s).y + blocks.get(s).size) * size - (savey - y) > ytab + i * size && ytab + (blocks.get(s).y + blocks.get(s).size) * size - (savey - y) < ytab + i * size + size)){
							if(!stop){
								stop = true;
									if(blocks.get(s).y < i){
										savei = i - blocks.get(s).size;
										lr = 1;
										if(bottom == 1000){
											bottom = y;
										}
									}
									else{
										savei = i + 1;
										lr = 0;
										if(top == -1000){
											top = y;
										}
									}
								break;
							}
						}
						else{
							if((lr == 0 && y > top) || (lr == 1 && y < bottom)){
								stop = false;
							}
						}
					}
				}
			}
			if(stop || oob){
				g.setColor(Color.ORANGE);
				g.fillRect(xtab + blocks.get(s).x * size + 3, ytab + savei * size + 3, size - 5, blocks.get(s).size * size - 5);
				g.setColor(Color.BLACK);
				g.drawRect(xtab + blocks.get(s).x * size + 2, ytab + savei * size + 2, size - 4, blocks.get(s).size * size - 4);
			}
			else if(!oob && !stop){
				g.setColor(Color.ORANGE);
				g.fillRect(xtab + blocks.get(s).x * size + 3, ytab + blocks.get(s).y * size + 3 - (savey - y), size - 5, blocks.get(s).size * size - 5);
				g.setColor(Color.BLACK);
				g.drawRect(xtab + blocks.get(s).x * size + 2, ytab + blocks.get(s).y * size + 2 - (savey - y), size - 4, blocks.get(s).size * size - 4);
			}
		}
		
		if(level > 1){
			g.setColor(Color.YELLOW);
			g.fillPolygon(backx, backy, 3);
		}
		
		if(level < cap){
			g.setColor(Color.YELLOW);
			g.fillPolygon(forwardx, forwardy, 3);
		}
		
		g.setColor(Color.YELLOW);
		g.setFont(f);
		if(level < 10){
			g.drawString("" + level, selectionx + 30, selectiony + 17);
		}
		else{
			g.drawString("" + level, selectionx + 23, selectiony + 17);
		}
		
		g.setColor(Color.BLACK);
		g.drawPolygon(backx, backy, 3);
		g.drawPolygon(forwardx, forwardy, 3);
		
		g.setColor(Color.YELLOW);
		g.fillOval(refreshx, refreshy, 20, 20);
		g.setColor(Color.BLACK);
		g.drawOval(refreshx, refreshy, 20, 20);
		
		g.setColor(Color.YELLOW);
		g.fillOval(undox, undoy, 20, 20);
		g.setColor(Color.BLACK);
		g.drawOval(undox, undoy, 20, 20);
		g.setColor(Color.DARK_GRAY);
		g.fillOval(undox + 5, undoy + 5, 10, 10);
		g.setColor(Color.BLACK);
		g.drawOval(undox + 5, undoy + 5, 10, 10);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(undox, undoy + 13, 10, 10);
		g.setColor(Color.BLACK);
		g.drawLine(undox + 10, undoy + 16, undox + 10, undoy + 20);
		g.setColor(Color.YELLOW);
		g.fillPolygon(undoarrowx, undoarrowy, 3);
		g.setColor(Color.BLACK);
		g.drawPolygon(undoarrowx, undoarrowy, 3);
		g.setColor(Color.YELLOW);
		g.drawLine(undox + 1, undoy + 10, undox + 4, undoy + 10);
		
		g.setColor(Color.YELLOW);
		if(movecounter < 10){
			g.drawString("" + movecounter, 394, 260);
		}
		else{
			g.drawString("" + movecounter, 387, 260);
		}
//		g.setColor(Color.WHITE);
//		g.drawString("t = " + top,20,20);
//		g.drawString("b = " + bottom,20,40);
//		g.drawString("l = " + left,20,60);
//		g.drawString("r = " + right,20,80);
//		g.drawString("oob = " + oob,20,100);
//		g.drawString("s = " + stop,20,120);
//		g.drawString("x = ",20,140);
//		g.drawString("y = ",20,160);
//		if(s < 100){
//			g.drawString("x = " + blocks.get(s).x,20,140);
//			g.drawString("y = " + blocks.get(s).y,20,160);
//		}
//		g.drawString("si = " + savei,20,180);
	}
}
