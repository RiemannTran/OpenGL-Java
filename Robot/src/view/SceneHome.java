package view;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jgl.GL;
import jgl.GLU;
import jgl.glu.GLUquadricObj;
import model.Bed;
import model.Box;
import model.Chair;
import model.Door;
import model.Fan;
import model.Human;
import model.Lamp;
import model.Sofa;
import model.Table;
import model.Wardrobe;
import model.Window;
import jgl.GLAUX;

public class SceneHome extends Applet implements ComponentListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GL myGL = new GL();
	GLU myGLU = new GLU(myGL);
	GLAUX myAUX = new GLAUX(myGL);
	GLUquadricObj qobj = myGLU.gluNewQuadric();

	Human human = new Human();
	Lamp lamp = new Lamp();
	Table table = new Table();
	Chair chair = new Chair();
	Fan fan = new Fan();
	Sofa sofa = new Sofa();
	Bed bed = new Bed();
	Box box = new Box();
	Wardrobe wardrobe = new Wardrobe();
	Door door = new Door();
	Window window = new Window();

	static float lx = 0.0f;
	static float lz = -1.0f;
	static float lxHuman = 0.0f;
	static float lzHuman = -1.0f;
	static float x = 0.0f;
	static float z =5.0f;
	static float xHuman = 3.0f;
	static float zHuman = 15.0f;
	static float rotaHuman = 0.0f;
	private float angle = 0.0f;
	float fraction = 0.1f;
	float fractionHuman = 1f;

	private static int legRight = 0;
	private static int legLeft = 0;
	private static int shoulderLeft = 0;
	private static int body = 0;
	private static int shoulderRight = 180;


	private static int anpha = 0;
	private static int doorIn = 0;
	private static int doorOut = 270;
	private static int window1 = 270;
	private static int window2 = 270;
	private float spin = 0;


	private byte imageFloor[][][];
	private byte imageFloorKhach[][][];
	private byte imageCenter[][][];
	private byte imageLeft[][][];
	private byte imageRight[][][];
	private byte imageTop[][][];
	private byte imageGround[][][];
	private byte imageNgoi[][][];
	private byte imageWallOut[][][];
	private byte imageBedRoom[][][];
	private byte imageNight[][][];
	private byte imageSkyOcean[][][];

	private int texName[] = new int[12];

	private void FanSubtractLeft() {

		do {
			spin += 2.0f;

		} while (spin > 360.0f);

//		spin = (spin - 5) % 360;

	}

	private void rotaHome() {
		anpha = (anpha + 5) % 360;
	}

	private void rotaHomeBack() {
		anpha = (anpha - 5) % 360;
	}


	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_W) {
			rotaHomeBack();
			display();
			repaint();
		} else if (keyCode == KeyEvent.VK_V) {
			left();
			display();
			repaint();
		} else if (keyCode == KeyEvent.VK_M) {
			right();
			display();
			repaint();
		} else if (keyCode == KeyEvent.VK_B) {
			up();
			display();
			repaint();
		} else if (keyCode == KeyEvent.VK_N) {
			down();
			display();
			repaint();
		} else if (keyCode == KeyEvent.VK_H) {
			back();
			shoulder();
			leg();
			display();
			repaint();
		} else if (keyCode == KeyEvent.VK_Y) {
			ahead();
			shoulder();
			leg();
			display();
			repaint();
		} else if (keyCode == KeyEvent.VK_G) {
			leftHuman();
			display();
			repaint();
		}else if (keyCode == KeyEvent.VK_J) {
			rightHuman();;
			display();
			repaint();
		}
		else if (keyCode == KeyEvent.VK_Q) {
			rotaHome();
			display();
			repaint();
		} else if (keyCode == KeyEvent.VK_P) {
			doorInSubtractLeft();
			display();
			repaint();
		}else if (keyCode == KeyEvent.VK_O) {
			doorOutAddLeft();
			display();
			repaint();
		}
		else if (keyCode == KeyEvent.VK_S) {
			windowOutAddLeft();
			display();
			repaint();
		}
		else if (keyCode == KeyEvent.VK_K) {
			windowOutAddRight();
			display();
			repaint();
		}
		else if (keyCode == KeyEvent.VK_F) {
			FanSubtractLeft();
			display();
			repaint();
		} else if (keyCode == KeyEvent.VK_A) {
			body();
			display();
			repaint();
		} else if (keyCode == KeyEvent.VK_R) {
			rotaHumanRight();
			display();
			repaint();
		}else if (keyCode == KeyEvent.VK_L) {
			rotaHumanLeft();
			display();
			repaint();
		}

	}

	private void leg() {
		if (legLeft < -10) {
			legLeft = 20;
		}
		if (legRight > 10) {
			legRight = -20;
		}
		legLeft = (legLeft - 5);
		legRight = (legRight + 5);
	}

	private void body() {
		if (body <-85) {
			body = 0;
		}
		body = (body - 5) % 360;
		
	}

	private void shoulder() {
		if (shoulderLeft < -45) {
			shoulderLeft = 45;
		}
		if (shoulderRight > 225) {
			shoulderRight = 135;
		}
		shoulderLeft = (shoulderLeft - 5);
		shoulderRight = (shoulderRight + 5);

	}

	private void doorInSubtractLeft() {
		doorIn = doorIn - 5 ;
		if (doorIn<-160) {
			doorIn = 0;
		}
	}
	private void doorOutAddLeft() {
		doorOut = doorOut + 5 ;
		if (doorOut>430) {
			doorOut = 270;
		}
	}
	
	private void windowOutAddLeft() {
		 window1= window1 + 5 ;
		if (window1>430) {
			window1 = 270;
		}
	}
	private void windowOutAddRight() {
		 window2= window2 + 5 ;
		if (window2>430) {
			window2 = 270;
		}
	}
	
	private void rotaHumanRight() {
		// TODO Auto-generated method stub
//		rotaHuman += 5;
		rotaHuman += 5f;
		lxHuman = (float) Math.sin(rotaHuman);
		lzHuman = (float) -Math.cos(rotaHuman);

	}
	private void rotaHumanLeft() {
		// TODO Auto-generated method stub
//		rotaHuman -= 5;
		rotaHuman -= 5f;
		lxHuman = (float) Math.sin(rotaHuman);
		lzHuman = (float) -Math.cos(rotaHuman);

	}
	

	private void rightHuman() {
		// TODO Auto-generated method stub
		xHuman += 0.5;

	}

	private void leftHuman() {
		// TODO Auto-generated method stub
		xHuman -= 0.5;

	}

	private void back() {
		zHuman += 0.5;
		// TODO Auto-generated method stub
//		zHuman += lzHuman*fractionHuman;
//		xHuman += lxHuman * fractionHuman;

	}

	private void ahead() {
		// TODO Auto-generated method stub
		zHuman -= 0.5;
//		zHuman -= lzHuman*fractionHuman;
//		xHuman -= lxHuman * fractionHuman;

	}

	private void left() {
		// TODO Auto-generated method stub
		angle -= 0.01f;
		lx = (float) Math.sin(angle);
		lz = (float) -Math.cos(angle);
	}

	private void right() {
		// TODO Auto-generated method stub
		angle += 0.01f;
		lx = (float) Math.sin(angle);
		lz = (float) -Math.cos(angle);
	}

	private void up() {
		// TODO Auto-generated method stub
		x += lx * fraction;
		z += lz * fraction;
	}

	private void down() {
		// TODO Auto-generated method stub
		x -= lx * fraction;
		z -= lz * fraction;
	}

	private void makeImage() throws IOException {

		BufferedImage imgCenter = ImageIO.read(new File("D://img//khach.jpg"));
		BufferedImage imgFloor = ImageIO.read(new File("D://img//floor.jpg"));
		BufferedImage imgTop = ImageIO.read(new File("D://img//tophouse.jpg"));
		BufferedImage imgLeft = ImageIO.read(new File("D://img//khachwall.jpg"));
		BufferedImage imgRight = ImageIO.read(new File("D://img//wall.jpg"));
		BufferedImage imgGround = ImageIO.read(new File("D://img//ground.jpg"));
		BufferedImage imgNgoi = ImageIO.read(new File("D://img//ngoi.jpg"));
		BufferedImage imgWallOut = ImageIO.read(new File("D://img//wallout.jpg"));
		BufferedImage imgBedRoom = ImageIO.read(new File("D://img//bedroom.jpg"));
		BufferedImage imgSky = ImageIO.read(new File("D://img//night.jpg"));
		BufferedImage imgFloorKhach = ImageIO.read(new File("D://img//floorkhach.jpg"));
		BufferedImage imgSkyOcean = ImageIO.read(new File("D://img//skyocean.jpg"));

		imageFloor = new byte[imgFloor.getWidth()][imgFloor.getHeight()][4];
		imageFloorKhach = new byte[imgFloor.getWidth()][imgFloor.getHeight()][4];
		imageCenter = new byte[imgCenter.getWidth()][imgCenter.getHeight()][4];
		imageLeft = new byte[imgLeft.getWidth()][imgLeft.getHeight()][4];
		imageRight = new byte[imgRight.getWidth()][imgRight.getHeight()][4];
		imageTop = new byte[imgTop.getWidth()][imgTop.getHeight()][4];
		imageGround = new byte[imgGround.getWidth()][imgGround.getHeight()][4];
		imageNgoi = new byte[imgNgoi.getWidth()][imgNgoi.getHeight()][4];
		imageWallOut = new byte[imgNgoi.getWidth()][imgNgoi.getHeight()][4];
		imageBedRoom = new byte[imgNgoi.getWidth()][imgNgoi.getHeight()][4];
		imageNight = new byte[imgSky.getWidth()][imgSky.getHeight()][4];
		imageSkyOcean = new byte[imgSkyOcean.getWidth()][imgSkyOcean.getHeight()][4];
		
		for (int i = 0; i < imgSkyOcean.getWidth(); i++) {
			for (int j = 0; j < imgSkyOcean.getHeight(); j++) {
				int rgbSkyOcean = imgSkyOcean.getRGB(i, j);
				Color c = new Color(rgbSkyOcean);

				imageSkyOcean[i][j][0] = (byte) c.getRed();
				imageSkyOcean[i][j][1] = (byte) c.getGreen();
				imageSkyOcean[i][j][2] = (byte) c.getBlue();
				imageSkyOcean[i][j][3] = (byte) 255;

			}
		}
		
		for (int i = 0; i < imgFloorKhach.getWidth(); i++) {
			for (int j = 0; j < imgFloorKhach.getHeight(); j++) {
				int rgbkhach = imgFloorKhach.getRGB(i, j);
				Color c = new Color(rgbkhach);

				imageFloorKhach[i][j][0] = (byte) c.getRed();
				imageFloorKhach[i][j][1] = (byte) c.getGreen();
				imageFloorKhach[i][j][2] = (byte) c.getBlue();
				imageFloorKhach[i][j][3] = (byte) 255;

			}
		}

		for (int i = 0; i < imgSky.getWidth(); i++) {
			for (int j = 0; j < imgSky.getHeight(); j++) {
				int rgbSky = imgSky.getRGB(i, j);
				Color c = new Color(rgbSky);

				imageBedRoom[i][j][0] = (byte) c.getRed();
				imageBedRoom[i][j][1] = (byte) c.getGreen();
				imageBedRoom[i][j][2] = (byte) c.getBlue();
				imageBedRoom[i][j][3] = (byte) 255;

			}
		}

		for (int i = 0; i < imgBedRoom.getWidth(); i++) {
			for (int j = 0; j < imgBedRoom.getHeight(); j++) {
				int rgbimgBedRoom = imgBedRoom.getRGB(i, j);
				Color c = new Color(rgbimgBedRoom);

				imageBedRoom[i][j][0] = (byte) c.getRed();
				imageBedRoom[i][j][1] = (byte) c.getGreen();
				imageBedRoom[i][j][2] = (byte) c.getBlue();
				imageBedRoom[i][j][3] = (byte) 255;

			}
		}

		for (int i = 0; i < imgWallOut.getWidth(); i++) {
			for (int j = 0; j < imgWallOut.getHeight(); j++) {
				int rgbWallOut = imgWallOut.getRGB(i, j);
				Color c = new Color(rgbWallOut);

				imageWallOut[i][j][0] = (byte) c.getRed();
				imageWallOut[i][j][1] = (byte) c.getGreen();
				imageWallOut[i][j][2] = (byte) c.getBlue();
				imageWallOut[i][j][3] = (byte) 255;

			}
		}

		for (int i = 0; i < imgNgoi.getWidth(); i++) {
			for (int j = 0; j < imgNgoi.getHeight(); j++) {
				int rgbNgoi = imgNgoi.getRGB(i, j);
				Color c = new Color(rgbNgoi);

				imageNgoi[i][j][0] = (byte) c.getRed();
				imageNgoi[i][j][1] = (byte) c.getGreen();
				imageNgoi[i][j][2] = (byte) c.getBlue();
				imageNgoi[i][j][3] = (byte) 255;

			}
		}

		for (int i = 0; i < imgGround.getWidth(); i++) {
			for (int j = 0; j < imgGround.getHeight(); j++) {
				int rgbGround = imgGround.getRGB(i, j);
				Color c = new Color(rgbGround);

				imageGround[i][j][0] = (byte) c.getRed();
				imageGround[i][j][1] = (byte) c.getGreen();
				imageGround[i][j][2] = (byte) c.getBlue();
				imageGround[i][j][3] = (byte) 255;

			}
		}
		for (int i = 0; i < imgFloor.getWidth(); i++) {
			for (int j = 0; j < imgFloor.getHeight(); j++) {
				int rgbFloor = imgFloor.getRGB(i, j);
				Color c = new Color(rgbFloor);

				imageFloor[i][j][0] = (byte) c.getRed();
				imageFloor[i][j][1] = (byte) c.getGreen();
				imageFloor[i][j][2] = (byte) c.getBlue();
				imageFloor[i][j][3] = (byte) 255;

			}
		}
		for (int i = 0; i < imgCenter.getWidth(); i++) {
			for (int j = 0; j < imgCenter.getHeight(); j++) {
				int rgbCenter = imgCenter.getRGB(i, j);
				Color c = new Color(rgbCenter);

				imageCenter[i][j][0] = (byte) c.getRed();
				imageCenter[i][j][1] = (byte) c.getGreen();
				imageCenter[i][j][2] = (byte) c.getBlue();
				imageCenter[i][j][3] = (byte) 255;

			}
		}

		for (int i = 0; i < imgLeft.getWidth(); i++) {
			for (int j = 0; j < imgLeft.getHeight(); j++) {
				int rgbLeft = imgLeft.getRGB(i, j);
				Color c = new Color(rgbLeft);

				imageLeft[i][j][0] = (byte) c.getRed();
				imageLeft[i][j][1] = (byte) c.getGreen();
				imageLeft[i][j][2] = (byte) c.getBlue();
				imageLeft[i][j][3] = (byte) 255;
			}
		}

		for (int i = 0; i < imgRight.getWidth(); i++) {
			for (int j = 0; j < imgRight.getHeight(); j++) {
				int rgbRight = imgRight.getRGB(i, j);
				Color c = new Color(rgbRight);

				imageRight[i][j][0] = (byte) c.getRed();
				imageRight[i][j][1] = (byte) c.getGreen();
				imageRight[i][j][2] = (byte) c.getBlue();
				imageRight[i][j][3] = (byte) 255;
			}
		}
		for (int i = 0; i < imgTop.getWidth(); i++) {
			for (int j = 0; j < imgTop.getHeight(); j++) {
				int rgbTop = imgTop.getRGB(i, j);
				Color c = new Color(rgbTop);

				imageTop[i][j][0] = (byte) c.getRed();
				imageTop[i][j][1] = (byte) c.getGreen();
				imageTop[i][j][2] = (byte) c.getBlue();
				imageTop[i][j][3] = (byte) 255;
			}
		}

	}

	private void display() {
		myGL.glDisable(GL.GL_LIGHTING);
		myGL.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		myGL.glEnable(GL.GL_POINT_SMOOTH);

		myGL.glPushMatrix();// scene
		myGL.glTranslatef(0.0f, 0.6f, -4.0f);
		myGLU.gluLookAt(x, 1.0f, z, x + lx, 1.0f, z + lz, 0.0f, 1.0f, 0.0f);
		
		myGL.glPushMatrix();
		myGL.glTranslatef(0f, -4f, 0f);
		myGL.glPushMatrix();
		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[11]);
		myGL.glBegin(GL.GL_QUADS);// center
		myGL.glColor3f(0.2f, 0.6f, 0.2f);
		myGL.glTexCoord2d(0.0, 0.0);
		myGL.glVertex3d(-10.0, 0, -10.0);
		myGL.glTexCoord2d(1.0, 0.0);
		myGL.glVertex3d(10.0, 0, -10.0);
		myGL.glTexCoord2d(1.0, 1.0);
		myGL.glVertex3d(10.0, 10, -10.0);
		myGL.glTexCoord2d(0.0, 1.0);
		myGL.glVertex3d(-10.0, 10, -10.0);
		myGL.glEnd();
		myGL.glPopMatrix();
		myGL.glDisable(GL.GL_TEXTURE_2D);
		
		myGL.glPushMatrix();
		myGL.glTranslatef(0.0f, 0.0f, 20.0f);
		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[11]);
		myGL.glBegin(GL.GL_QUADS);// center
		myGL.glColor3f(0.2f, 0.6f, 0.2f);
		myGL.glTexCoord2d(0.0, 0.0);
		myGL.glVertex3d(-10.0, 0, -10.0);
		myGL.glTexCoord2d(1.0, 0.0);
		myGL.glVertex3d(10.0, 0, -10.0);
		myGL.glTexCoord2d(1.0, 1.0);
		myGL.glVertex3d(10.0, 10, -10.0);
		myGL.glTexCoord2d(0.0, 1.0);
		myGL.glVertex3d(-10.0, 10, -10.0);
		myGL.glEnd();
		myGL.glPopMatrix();
		myGL.glDisable(GL.GL_TEXTURE_2D);
		
		myGL.glPushMatrix();
		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[11]);
		myGL.glBegin(GL.GL_QUADS);// right
		myGL.glColor3f(0.2f, 0.2f, 0.3f);
		myGL.glTexCoord2d(0.0, 0.0);
		myGL.glVertex3d(10.0, 0, -10.0);
		myGL.glTexCoord2d(1.0, 0.0);
		myGL.glVertex3d(10.0, 0, 10.0);
		myGL.glTexCoord2d(1.0, 1.0);
		myGL.glVertex3d(10.0, 10, 10.0);
		myGL.glTexCoord2d(0.0, 1.0);
		myGL.glVertex3d(10.0, 10, -10.0);
		myGL.glEnd();
		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glPopMatrix();
		
		myGL.glPushMatrix();
		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[11]);
		myGL.glBegin(GL.GL_QUADS);// left
		myGL.glColor3f(0.5f, 0.2f, 0.3f);
		myGL.glTexCoord2d(0.0, 0.0);
		myGL.glVertex3d(-10.0, 0, 10.0);
		myGL.glTexCoord2d(1.0, 0.0);
		myGL.glVertex3d(-10.0, 10, 10.0);
		myGL.glTexCoord2d(1.0, 1.0);
		myGL.glVertex3d(-10.0, 10, -10.0);
		myGL.glTexCoord2d(0.0, 1.0);
		myGL.glVertex3d(-10.0, 0, -10.0);
		myGL.glEnd();
		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glPopMatrix();
		
		myGL.glPushMatrix();
		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[11]);
		myGL.glBegin(GL.GL_QUADS);// top
		myGL.glColor3f(0.5f, 1.0f, 0.8f);
		myGL.glTexCoord2d(0.0, 0.0);
		myGL.glVertex3d(-10.0, 10, 10.0);
		myGL.glTexCoord2d(1.0, 0.0);
		myGL.glVertex3d(10.0, 10, 10.0);
		myGL.glTexCoord2d(1.0, 1.0);
		myGL.glVertex3d(10.0, 10, -10.0);
		myGL.glTexCoord2d(0.0, 1.0);
		myGL.glVertex3d(-10.0, 10, -10.0);
		myGL.glEnd();
		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glPopMatrix();

		myGL.glPushMatrix();// home
		myGL.glTranslatef(0f, 4.0f, 0.0f);
		myGL.glScaled(0.2, 0.2, 0.2);
		myGL.glRotatef((float) anpha, 0.0f, 1.0f, 0.0f);
		myGL.glDisable(GL.GL_LIGHTING);
		myGL.glTranslatef(0.0f, -3.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[0]);
		myGL.glBegin(GL.GL_QUADS);// botom
		myGL.glTexCoord2d(0.0, 0.0);
		myGL.glVertex3d(0.0, 0, 10.0);
		myGL.glTexCoord2d(1.0, 0.0);
		myGL.glVertex3d(12.0, 0, 10.0);
		myGL.glTexCoord2d(1.0, 1.0);
		myGL.glVertex3d(12.0, 0, -10.0);
		myGL.glTexCoord2d(0.0, 1.0);
		myGL.glVertex3d(0.0, 0, -10.0);
		myGL.glEnd();
		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glPopMatrix();
		
		myGL.glPushMatrix();
		myGL.glTranslatef(-15f, 0.0f, 0.0f);
		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[10]);
		myGL.glBegin(GL.GL_QUADS);// botom
		myGL.glTexCoord2d(0.0, 0.0);
		myGL.glVertex3d(0.0, 0, 10.0);
		myGL.glTexCoord2d(1.0, 0.0);
		myGL.glVertex3d(15.0, 0, 10.0);
		myGL.glTexCoord2d(1.0, 1.0);
		myGL.glVertex3d(15.0, 0, -10.0);
		myGL.glTexCoord2d(0.0, 1.0);
		myGL.glVertex3d(0.0, 0, -10.0);
		myGL.glEnd();
		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glRotatef((float) 30, 1.0f, 0.0f, 0.0f);
		myGL.glTranslatef(-1.5f, 13.9f, 0f);
		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[6]);
		myGL.glBegin(GL.GL_QUADS);// ngoi
		myGL.glTexCoord2d(0.0, 0.0);
		myGL.glVertex3d(-15.0, 0, 8.0);
		myGL.glTexCoord2d(1.0, 0.0);
		myGL.glVertex3d(15.0, 0, 8.0);
		myGL.glTexCoord2d(1.0, 1.0);
		myGL.glVertex3d(15.0, 0, -8.0);
		myGL.glTexCoord2d(0.0, 1.0);
		myGL.glVertex3d(-15.0, 0, -8.0);
		myGL.glEnd();
		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glRotatef((float) -30, 1.0f, 0.0f, 0.0f);
		myGL.glTranslatef(-1.5f, 13.9f, 0f);
		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[6]);
		myGL.glBegin(GL.GL_QUADS);// ngoi
		myGL.glTexCoord2d(0.0, 0.0);
		myGL.glVertex3d(-15.0, 0, 8.0);
		myGL.glTexCoord2d(1.0, 0.0);
		myGL.glVertex3d(15.0, 0, 8.0);
		myGL.glTexCoord2d(1.0, 1.0);
		myGL.glVertex3d(15.0, 0, -8.0);
		myGL.glTexCoord2d(0.0, 1.0);
		myGL.glVertex3d(-15.0, 0, -8.0);
		myGL.glEnd();
		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glPopMatrix();
		
		

		// vach font
		drawVachFont();

		myGL.glPushMatrix();// vach
		myGL.glColor3f(1.0f, 0.7f, 0.6f);
		myGL.glTranslatef(0f, 5.0f, -6.0f);
		myGL.glScaled(1, 1, 0.6);
		myAUX.auxSolidBox(0.2, 10, 14);
		myGL.glPopMatrix();

		myGL.glPushMatrix();// vach
		myGL.glColor3f(1.0f, 0.7f, 0.6f);
		myGL.glTranslatef(0f, 5.0f, 5.5f);
		myGL.glScaled(1, 1, 0.6);
		myAUX.auxSolidBox(0.2, 10, 14);
		myGL.glPopMatrix();

		myGL.glPushMatrix();// vach
		myGL.glColor3f(1.0f, 0.7f, 0.6f);
		myGL.glTranslatef(0f, 8.5f, 0f);
		myGL.glScaled(1, 1, 0.6);
		myAUX.auxSolidBox(0.2, 3, 14);
		myGL.glPopMatrix();

		myGL.glPushMatrix();// tuong phai
		myGL.glColor3f(1.0f, 0.7f, 0.6f);
		myGL.glTranslatef(12.3f, 5.0f, 0.0f);
		myGL.glScaled(1, 1, 0.6);
		myAUX.auxSolidBox(0.5, 10, 34);
		myGL.glPopMatrix();

		myGL.glPushMatrix();// tuong center
		myGL.glColor3f(1.0f, 0.7f, 0.6f);
		myGL.glTranslatef(-1.5f, 5.0f, -10.2f);
		myGL.glScaled(1, 1, 0.6);
		myAUX.auxSolidBox(28, 10, 0.5);
		myGL.glPopMatrix();

		myGL.glPushMatrix();// tuong trai
		myGL.glColor3f(1.0f, 0.7f, 0.6f);
		myGL.glTranslatef(-15.3f, 5.0f, 0.0f);
		myGL.glScaled(1, 1, 0.6);
		myAUX.auxSolidBox(0.5, 10, 34);
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[3]);
		myGL.glBegin(GL.GL_QUADS);// right
		myGL.glTexCoord2d(0.0, 0.0);
		myGL.glVertex3d(12.0, 0, -10.0);
		myGL.glTexCoord2d(1.0, 0.0);
		myGL.glVertex3d(12.0, 0, 10.0);
		myGL.glTexCoord2d(1.0, 1.0);
		myGL.glVertex3d(12.0, 10, 10.0);
		myGL.glTexCoord2d(0.0, 1.0);
		myGL.glVertex3d(12.0, 10, -10.0);
		myGL.glEnd();
		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glTranslatef(0.6f, 0, 0);
		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[7]);
		myGL.glBegin(GL.GL_QUADS);// right wall out
		myGL.glTexCoord2d(0.0, 0.0);
		myGL.glVertex3d(12.0, 0, -10.0);
		myGL.glTexCoord2d(1.0, 0.0);
		myGL.glVertex3d(12.0, 0, 10.0);
		myGL.glTexCoord2d(1.0, 1.0);
		myGL.glVertex3d(12.0, 10, 10.0);
		myGL.glTexCoord2d(0.0, 1.0);
		myGL.glVertex3d(12.0, 10, -10.0);
		myGL.glEnd();
		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[2]);
		myGL.glBegin(GL.GL_QUADS);// left
		myGL.glTexCoord2d(0.0, 0.0);
		myGL.glVertex3d(-15.0, 0, -10.0);
		myGL.glTexCoord2d(1.0, 0.0);
		myGL.glVertex3d(-15.0, 0, 10.0);
		myGL.glTexCoord2d(1.0, 1.0);
		myGL.glVertex3d(-15.0, 10, 10.0);
		myGL.glTexCoord2d(0.0, 1.0);
		myGL.glVertex3d(-15.0, 10, -10.0);
		myGL.glEnd();
		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glPopMatrix();
//
		myGL.glPushMatrix();
		myGL.glTranslatef(-0.6f, 0, 0);
		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[7]);
		myGL.glBegin(GL.GL_QUADS);// left wall out
		myGL.glTexCoord2d(0.0, 0.0);
		myGL.glVertex3d(-15.0, 0, -10.0);
		myGL.glTexCoord2d(1.0, 0.0);
		myGL.glVertex3d(-15.0, 0, 10.0);
		myGL.glTexCoord2d(1.0, 1.0);
		myGL.glVertex3d(-15.0, 10, 10.0);
		myGL.glTexCoord2d(0.0, 1.0);
		myGL.glVertex3d(-15.0, 10, -10.0);
		myGL.glEnd();
		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[4]);
		myGL.glBegin(GL.GL_QUADS);// top
		myGL.glColor3f(0.5f, 1.0f, 0.8f);
		myGL.glTexCoord2d(0.0, 0.0);
		myGL.glVertex3d(-15.0, 10, 10.0);
		myGL.glTexCoord2d(1.0, 0.0);
		myGL.glVertex3d(12.0, 10, 10.0);
		myGL.glTexCoord2d(1.0, 1.0);
		myGL.glVertex3d(12.0, 10, -10.0);
		myGL.glTexCoord2d(0.0, 1.0);
		myGL.glVertex3d(-15.0, 10, -10.0);
		myGL.glEnd();
		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glScaled(0.5, 1.0, 1.0);
		myGL.glTranslatef(-15.0f, 0.0f, 0.0f);
		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[1]);
		myGL.glBegin(GL.GL_QUADS);// center
		myGL.glColor3f(0.2f, 0.6f, 0.2f);
		myGL.glTexCoord2d(0.0, 0.0);
		myGL.glVertex3d(-15.0, 0, -10.0);
		myGL.glTexCoord2d(1.0, 0.0);
		myGL.glVertex3d(15.0, 0, -10.0);
		myGL.glTexCoord2d(1.0, 1.0);
		myGL.glVertex3d(15.0, 10.05, -10.0);
		myGL.glTexCoord2d(0.0, 1.0);
		myGL.glVertex3d(-15.0, 10.05, -10.0);
		myGL.glEnd();
		myGL.glPopMatrix();
		myGL.glDisable(GL.GL_TEXTURE_2D);

		myGL.glPushMatrix();
		myGL.glScaled(0.5, 1.0, 1.0);
		myGL.glTranslatef(15.0f, 0.0f, 0.0f);
		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[8]);
		myGL.glBegin(GL.GL_QUADS);// center
		myGL.glColor3f(0.2f, 0.6f, 0.2f);
		myGL.glTexCoord2d(0.0, 0.0);
		myGL.glVertex3d(-15.0, 0, -10.0);
		myGL.glTexCoord2d(1.0, 0.0);
		myGL.glVertex3d(10.0, 0, -10.0);
		myGL.glTexCoord2d(1.0, 1.0);
		myGL.glVertex3d(10.0, 10.05, -10.0);
		myGL.glTexCoord2d(0.0, 1.0);
		myGL.glVertex3d(-15.0, 10.05, -10.0);
		myGL.glEnd();
		myGL.glPopMatrix();
		myGL.glDisable(GL.GL_TEXTURE_2D);

		myGL.glPushMatrix();
		myGL.glTranslatef(0.0f, 0.0f, -0.4f);
		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[7]);
		myGL.glBegin(GL.GL_QUADS);// center wall out
		myGL.glColor3f(0.2f, 0.6f, 0.3f);
		myGL.glTexCoord2d(0.0, 0.0);
		myGL.glVertex3d(-15.5, 0, -10.0);
		myGL.glTexCoord2d(1.0, 0.0);
		myGL.glVertex3d(12.5, 0, -10.0);
		myGL.glTexCoord2d(1.0, 1.0);
		myGL.glVertex3d(12.5, 10, -10.0);
		myGL.glTexCoord2d(0.0, 1.0);
		myGL.glVertex3d(-15.5, 10, -10.0);
		myGL.glEnd();
		myGL.glPopMatrix();
		myGL.glDisable(GL.GL_TEXTURE_2D);

		myGL.glPushMatrix();
		myGL.glTranslatef(0.0f, -0.3f, 15.0f);
		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[5]);
		myGL.glBegin(GL.GL_QUADS);// ground
		myGL.glColor3f(0.5f, 0.7f, 0.6f);
		myGL.glTexCoord2d(0.0, 0.0);
		myGL.glVertex3d(-15.0, 0, 15.0);
		myGL.glTexCoord2d(1.0, 0.0);
		myGL.glVertex3d(15.0, 0, 15.0);
		myGL.glTexCoord2d(1.0, 1.0);
		myGL.glVertex3d(15.0, 0, -15.0);
		myGL.glTexCoord2d(0.0, 1.0);
		myGL.glVertex3d(-15.0, 0, -15.0);
		myGL.glEnd();
		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glDisable(GL.GL_LIGHTING);
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glTranslatef(30.0f, -0.3f, 15.0f);
		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[5]);
		myGL.glBegin(GL.GL_QUADS);// ground
		myGL.glColor3f(0.5f, 0.7f, 0.6f);
		myGL.glTexCoord2d(0.0, 0.0);
		myGL.glVertex3d(-15.0, 0, 15.0);
		myGL.glTexCoord2d(1.0, 0.0);
		myGL.glVertex3d(15.0, 0, 15.0);
		myGL.glTexCoord2d(1.0, 1.0);
		myGL.glVertex3d(15.0, 0, -15.0);
		myGL.glTexCoord2d(0.0, 1.0);
		myGL.glVertex3d(-15.0, 0, -15.0);
		myGL.glEnd();
		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glDisable(GL.GL_LIGHTING);
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glTranslatef(-30.0f, -0.3f, 15.0f);
		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[5]);
		myGL.glBegin(GL.GL_QUADS);// ground
		myGL.glColor3f(0.5f, 0.7f, 0.6f);
		myGL.glTexCoord2d(0.0, 0.0);
		myGL.glVertex3d(-15.0, 0, 15.0);
		myGL.glTexCoord2d(1.0, 0.0);
		myGL.glVertex3d(15.0, 0, 15.0);
		myGL.glTexCoord2d(1.0, 1.0);
		myGL.glVertex3d(15.0, 0, -15.0);
		myGL.glTexCoord2d(0.0, 1.0);
		myGL.glVertex3d(-15.0, 0, -15.0);
		myGL.glEnd();
		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glDisable(GL.GL_LIGHTING);
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glTranslatef(0.0f, -0.3f, -15.0f);
		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[5]);
		myGL.glBegin(GL.GL_QUADS);// ground
		myGL.glColor3f(0.5f, 0.7f, 0.6f);
		myGL.glTexCoord2d(0.0, 0.0);
		myGL.glVertex3d(-15.0, 0, 15.0);
		myGL.glTexCoord2d(1.0, 0.0);
		myGL.glVertex3d(15.0, 0, 15.0);
		myGL.glTexCoord2d(1.0, 1.0);
		myGL.glVertex3d(15.0, 0, -15.0);
		myGL.glTexCoord2d(0.0, 1.0);
		myGL.glVertex3d(-15.0, 0, -15.0);
		myGL.glEnd();
		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glDisable(GL.GL_LIGHTING);
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glTranslatef(30.0f, -0.3f, -15.0f);
		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[5]);
		myGL.glBegin(GL.GL_QUADS);// ground
		myGL.glColor3f(0.5f, 0.7f, 0.6f);
		myGL.glTexCoord2d(0.0, 0.0);
		myGL.glVertex3d(-15.0, 0, 15.0);
		myGL.glTexCoord2d(1.0, 0.0);
		myGL.glVertex3d(15.0, 0, 15.0);
		myGL.glTexCoord2d(1.0, 1.0);
		myGL.glVertex3d(15.0, 0, -15.0);
		myGL.glTexCoord2d(0.0, 1.0);
		myGL.glVertex3d(-15.0, 0, -15.0);
		myGL.glEnd();
		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glDisable(GL.GL_LIGHTING);
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glTranslatef(-30.0f, -0.3f, -15.0f);
		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[5]);
		myGL.glBegin(GL.GL_QUADS);// ground
		myGL.glColor3f(0.5f, 0.7f, 0.6f);
		myGL.glTexCoord2d(0.0, 0.0);
		myGL.glVertex3d(-15.0, 0, 15.0);
		myGL.glTexCoord2d(1.0, 0.0);
		myGL.glVertex3d(15.0, 0, 15.0);
		myGL.glTexCoord2d(1.0, 1.0);
		myGL.glVertex3d(15.0, 0, -15.0);
		myGL.glTexCoord2d(0.0, 1.0);
		myGL.glVertex3d(-15.0, 0, -15.0);
		myGL.glEnd();
		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glDisable(GL.GL_LIGHTING);
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glTranslatef(-1, 0, 0);

		myGL.glPushMatrix();// phong khach
		myGL.glTranslatef(-0.5f, 0, 0);

		myGL.glEnable(GL.GL_LIGHTING);
		myGL.glPushMatrix();// doorOut
		myGL.glTranslatef(-11.1f, 5f, 10f);
		myGL.glRotatef( doorOut, 0.0f, 1.0f, 0.0f);
		door.display(myGL, myAUX, myGLU, qobj);
		myGL.glPopMatrix();// doorOut
		myGL.glDisable(GL.GL_LIGHTING);
		
		myGL.glPushMatrix();//window1
		
		myGL.glScalef(0.52f, 0.56f, 1.0f);
		myGL.glTranslatef(-3.37f, 5.4f, 0f);
		myGL.glEnable(GL.GL_LIGHTING);
		
		myGL.glPushMatrix();// window
		myGL.glTranslatef(-4f, 5.0f, 10f);
		myGL.glRotatef( window1, 0.0f, 1.0f, 0.0f);
		window.display(myGL, myAUX, myGLU, qobj);
		myGL.glPopMatrix();// window

		myGL.glEnable(GL.GL_LIGHTING);
		myGL.glPushMatrix();// window
		myGL.glTranslatef(2.4f, 5.0f, 10f);
		myGL.glScalef(-1.0f, 1.0f, 1.0f);
		myGL.glRotatef( window1, 0.0f, 1.0f, 0.0f);
		window.display(myGL, myAUX, myGLU, qobj);
		myGL.glPopMatrix();// window
		
		myGL.glPopMatrix();//widow1
		
        myGL.glPushMatrix();//window2
		
		myGL.glScalef(0.54f, 0.56f, 1.0f);
		myGL.glTranslatef(14.25f, 5.4f, 0f);
		myGL.glEnable(GL.GL_LIGHTING);
		
		myGL.glPushMatrix();// window
		myGL.glTranslatef(-4f, 5.0f, 10f);
		myGL.glRotatef( window2, 0.0f, 1.0f, 0.0f);
		window.display(myGL, myAUX, myGLU, qobj);
		myGL.glPopMatrix();// window

		myGL.glEnable(GL.GL_LIGHTING);
		myGL.glPushMatrix();// window
		myGL.glTranslatef(2.4f, 5.0f, 10f);
		myGL.glScalef(-1.0f, 1.0f, 1.0f);
		myGL.glRotatef( window2, 0.0f, 1.0f, 0.0f);
		window.display(myGL, myAUX, myGLU, qobj);
		myGL.glPopMatrix();// window
		
		myGL.glPopMatrix();//widow2
		


		myGL.glEnable(GL.GL_LIGHTING);
		myGL.glPushMatrix();// doorIn
		myGL.glTranslatef(1.5f, 5.0f, 1.4f);
		myGL.glRotatef( doorIn, 0.0f, 1.0f, 0.0f);
		door.display(myGL, myAUX, myGLU, qobj);
		myGL.glPopMatrix();// doorIn
		myGL.glDisable(GL.GL_LIGHTING);

		myGL.glEnable(GL.GL_LIGHTING);
		myGL.glPushMatrix();// table
		myGL.glTranslatef(-5, 2.0f, -5);
		table.display(myGL, myAUX, qobj);;
		myGL.glPopMatrix();// table
		myGL.glDisable(GL.GL_LIGHTING);

		myGL.glEnable(GL.GL_LIGHTING);
		myGL.glPushMatrix();// tableSmall
		myGL.glTranslatef(-6, 1.0f, 5);
		myGL.glScalef(0.6f, 0.5f, 1.0f);
		table.display(myGL, myAUX, qobj);
		myGL.glPopMatrix();// tableSmall
		myGL.glDisable(GL.GL_LIGHTING);

		myGL.glEnable(GL.GL_LIGHTING);
		myGL.glPushMatrix();// chair1
		myGL.glTranslatef(-2, 0, -5);
		myGL.glRotatef((float) -90, 0.0f, 1.0f, 0.0f);
		chair.display(myGL, myAUX, myGLU, qobj);
		myGL.glPopMatrix();// chair1
		myGL.glDisable(GL.GL_LIGHTING);

		myGL.glEnable(GL.GL_LIGHTING);
		myGL.glPushMatrix();// chair2
		myGL.glTranslated(-6, 0, -2.5);
		myGL.glRotatef((float) 180, 0.0f, 1.0f, 0.0f);
		chair.display(myGL, myAUX, myGLU, qobj);
		myGL.glPopMatrix();// chair2
		myGL.glDisable(GL.GL_LIGHTING);

		myGL.glEnable(GL.GL_LIGHTING);
		myGL.glPushMatrix();// quat
		myGL.glScalef(0.7f, 0.7f, 0.7f);
		myGL.glTranslatef(-5f, 11f, 8.0f);
		myGL.glRotated((double) spin, 0.0, 1.0, 0.0);
		fan.display(myGL, myAUX, myGLU, qobj);
		myGL.glPopMatrix();// quat
		myGL.glDisable(GL.GL_LIGHTING);

		myGL.glPushMatrix();// tv

		myGL.glPopMatrix();

		myGL.glEnable(GL.GL_LIGHTING);
		myGL.glPushMatrix();// sofa
		myGL.glTranslated(-2, 0.5, 5);
		sofa.display(myGL, myAUX, myGLU, qobj);
		myGL.glPopMatrix();// sofa
		myGL.glDisable(GL.GL_LIGHTING);

		myGL.glPopMatrix();// phong khach

		myGL.glPushMatrix();// phong ngu
		myGL.glTranslated(2.5, 0, 0);

		myGL.glEnable(GL.GL_LIGHTING);
		myGL.glPushMatrix();// bed
		myGL.glTranslated(6.0, 0.5, -5);
		bed.display(myGL, myAUX, myGLU, qobj);
		myGL.glPopMatrix();// bed
		myGL.glDisable(GL.GL_LIGHTING);

		myGL.glEnable(GL.GL_LIGHTING);
		myGL.glPushMatrix();// lamp
		myGL.glTranslated(9.0, 0.9, -3.0);
		myGL.glScaled(0.5, 0.5, 1.0);
		lamp.display(myGL, myAUX, myGLU, qobj);
		myGL.glPopMatrix();// lamp
		myGL.glDisable(GL.GL_LIGHTING);

		myGL.glEnable(GL.GL_LIGHTING);
		myGL.glPushMatrix();// box
		box.display(myGL, myAUX, myGLU, qobj);
		myGL.glPopMatrix();// box
		myGL.glDisable(GL.GL_LIGHTING);

		myGL.glEnable(GL.GL_LIGHTING);
		myGL.glPushMatrix();// tu do
		myGL.glTranslated(8.7, 2.7, 5);
		myGL.glRotatef((float) -90, 0.0f, 1.0f, 0.0f);
		wardrobe.display(myGL, myAUX, myGLU, qobj);
		myGL.glPopMatrix();// tu do
		myGL.glDisable(GL.GL_LIGHTING);

		myGL.glPopMatrix();// phong ngu

		myGL.glEnable(GL.GL_LIGHTING);
		myGL.glPushMatrix();// robot
		myGL.glRotatef(rotaHuman, 0.0f, 1.0f, 0.0f);
//		myGL.glTranslated(xHuman, 3, z+15);
//		myGL.glPushMatrix();
//		myGL.glPushMatrix();
		myGL.glTranslated(xHuman, 3, zHuman);
		myGL.glScalef(0.5f, 0.45f, 0.7f);
		human.display(myGL, myAUX, legRight, legLeft, shoulderRight, shoulderLeft, body);
		myGL.glPopMatrix();// robot
//		myGL.glPopMatrix();
//		myGL.glPopMatrix();
		myGL.glDisable(GL.GL_LIGHTING);

		myGL.glPopMatrix();// home
		
		myGL.glPopMatrix();

		myGL.glPopMatrix();// scene

		myGL.glDisable(GL.GL_LIGHTING);

		myGL.glFlush();
	}


	private void drawVachFont() {
		myGL.glPushMatrix();// vach font
		myGL.glColor3f(0.2f, 0.7f, 0.6f);
		myGL.glTranslatef(0f, 8.5f, 10f);
		myGL.glScaled(1, 1, 0.6);
		myAUX.auxSolidBox(25, 3, 0.5);
		myGL.glPopMatrix();

		myGL.glPushMatrix();// vach font
		myGL.glColor3f(0.2f, 0.7f, 0.6f);
		myGL.glTranslatef(2f, 1.5f, 10f);
		myGL.glScaled(1, 1, 0.6);
		myAUX.auxSolidBox(18, 3, 0.5);
		myGL.glPopMatrix();

		myGL.glPushMatrix();// vach font
		myGL.glColor3f(0.2f, 0.7f, 0.6f);
		myGL.glTranslatef(-14f, 5f, 10f);
		myGL.glScaled(1, 1, 0.6);
		myAUX.auxSolidBox(3, 10, 0.5);
		myGL.glPopMatrix();

		myGL.glPushMatrix();// vach font
		myGL.glColor3f(0.2f, 0.7f, 0.6f);
		myGL.glTranslatef(1f, 5.0f, 10f);
		myGL.glScaled(1, 1, 0.6);
		myAUX.auxSolidBox(6, 10, 0.5);
		myGL.glPopMatrix();
		
		myGL.glPushMatrix();// vach font
//		myGL.glScaled(0.4, 1, 1);
		myGL.glColor3f(0.2f, 0.7f, 0.6f);
		myGL.glTranslatef(-7.4f, 5.0f, 10f);
		myGL.glScaled(1, 1, 0.6);
		myAUX.auxSolidBox(4, 10, 0.5);
		myGL.glPopMatrix();

		myGL.glPushMatrix();// vach font
		myGL.glColor3f(0.2f, 0.7f, 0.6f);
		myGL.glTranslatef(10f, 5.0f, 10f);
		myGL.glScaled(1, 1, 0.6);
		myAUX.auxSolidBox(5, 10, 0.5);
		myGL.glPopMatrix();
	}

	public void setMaterialColor(float ambien[], float diff_use[]) {
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, ambien);
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, diff_use);

	};

	private void initlights() {
		float ambient[] = { 0.3f, 0.2f, 0.5f, 1.0f };
		float position[] = { 1.0f, 1.0f, 1.0f, 0.0f };
		float mat_diffuse[] = { 0.5f, 0.2f, 0.6f, 1.0f };
		float mat_specular[] = { 1.0f, 0.8f, 0.7f, 1.0f };
		float mat_shininess[] = { 40.0f };

		myGL.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, ambient);
		myGL.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, mat_diffuse );
		myGL.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, mat_specular);
		myGL.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, position);

		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse);
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular);
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, ambient);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess);

		myGL.glEnable(GL.GL_LIGHTING);
		myGL.glEnable(GL.GL_LIGHT0);
		myGL.glEnable(GL.GL_DEPTH_TEST);
	}

	private void myinit() throws IOException {
		myGL.glShadeModel(GL.GL_SMOOTH);
		myGL.glPixelStorei(GL.GL_UNPACK_ALIGNMENT, 1);

		makeImage();

		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glGenTextures(12, texName);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[0]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, imageFloor[0].length, imageFloor.length, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageFloor);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[1]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, imageCenter[0].length, imageCenter.length, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageCenter);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[2]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, imageLeft[0].length, imageLeft.length, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageLeft);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[3]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, imageRight[0].length, imageRight.length, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageRight);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[4]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, imageTop[0].length, imageTop.length, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageTop);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[5]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, imageGround[0].length, imageGround.length, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageGround);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[6]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, imageNgoi[0].length, imageNgoi.length, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageNgoi);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[7]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, imageWallOut[0].length, imageWallOut.length, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageWallOut);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[8]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, imageBedRoom[0].length, imageBedRoom.length, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageBedRoom);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[9]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, imageNight[0].length, imageNight.length, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageNight);
		
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[10]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, imageFloorKhach[0].length, imageFloorKhach.length, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageFloorKhach);
		
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[11]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, imageSkyOcean[0].length, imageSkyOcean.length, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageSkyOcean);
		


		initlights();
	}

	public void componentMoved(ComponentEvent e) {
	}

	public void componentShown(ComponentEvent e) {
	}

	public void componentHidden(ComponentEvent e) {
	}

	public void componentResized(ComponentEvent e) {
		// get window width and height by myself
		myReshape(getSize().width, getSize().height);
		display();
		repaint();
	}

	private void myReshape(int w, int h) {
		myGL.glViewport(0, 0, w, h);
		myGL.glMatrixMode(GL.GL_PROJECTION);
		myGL.glLoadIdentity();
		myGLU.gluPerspective(400.0, (double) w / (double) h, 1.0, 4000.0);
		myGL.glMatrixMode(GL.GL_MODELVIEW);
		myGL.glLoadIdentity();
//		myGL.glTranslatef(0.0f, 0.0f, -5.0f);
//		myGLU.gluLookAt(0, 0, z1, 0, 0, 0, 0, 1, 0);
	}

	public void update(Graphics g) {
		// skip the clear screen command....
		paint(g);
	}

	public void paint(Graphics g) {
		myGL.glXSwapBuffers(g, this);
	}

	public void init() {
		myAUX.auxInitPosition(0, 0, 1000, 600);
		myAUX.auxInitWindow(this);
		try {
			myinit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// as call auxKeyFunc()
		addKeyListener(this);

		// as call auxReshapeFunc()
		addComponentListener(this);
		myReshape(getSize().width, getSize().height);

		// call display as call auxIdleFunc(display)
		display();

	}

}
