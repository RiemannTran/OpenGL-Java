package model;

import jgl.GL;
import jgl.GLAUX;
import jgl.GLU;
import jgl.glu.GLUquadricObj;

public class Fan {

	public Fan() {
		// TODO Auto-generated constructor stub
	}
	
	public void setMaterialColor(GL myGL,float ambien[], float diff_use[]) {
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, ambien);
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, diff_use);

	};

	public void setMaterialColor(GL myGL,String type) {
		float ambien[] = { 0.0f, 0.0f, 0.0f, 1.0f };
		float diff_use[] = { 0.0f, 0.0f, 0.0f, 1.0f };
		switch (type) {
		case "K_MAT_RED": {
			ambien[0] = 1.0f;
			diff_use[0] = 1.0f;
		}
			break;
		case "K_MAT_GREEN": {
			ambien[1] = 1.0f;
			diff_use[1] = 1.0f;
		}
			break;
		case "K_MAT_BLUE": {
			ambien[2] = 1.0f;
			diff_use[2] = 1.0f;
		}
			break;
		case "K_MAT_YELLOW": {
			ambien[0] = 1.0f;
			ambien[1] = 1.0f;
			diff_use[0] = 1.0f;
			diff_use[1] = 1.0f;
		}
			break;
		case "K_MAT_PINK": {
			ambien[0] = 1.0f;
			ambien[2] = 1.0f;
			diff_use[0] = 1.0f;
			diff_use[1] = 1.0f;
		}
			break;
		default:

			ambien[0] = 1.0f;
			ambien[1] = 1.0f;
			ambien[2] = 1.0f;
			diff_use[0] = 1.0f;
			diff_use[1] = 1.0f;
			diff_use[2] = 1.0f;

		}
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, ambien);
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, diff_use);
	}
	public void display(GL myGL,GLAUX myAUX,GLU myGLU,GLUquadricObj qobj) {
		
		myGL.glRotatef((float) -90, 1.0f, .0f, 0.0f);

		float ambien[] = { 0.0f, 1.0f, 0.0f, 1.0f  };
		float diff_use[] = { 0.0f, 1.0f, 0.0f, 1.0f};
		setMaterialColor(myGL, ambien, diff_use);
		myAUX.auxSolidSphere(0.5);

		float ambien1[] = { 1.0f, 1.0f, 1.0f, 1.0f  };
		float diff_use1[] = { 1.0f, 1.0f, 1.0f, 1.0f};
		setMaterialColor(myGL, ambien1, diff_use1);
		myAUX.auxSolidSphere(0.5);
		myGL.glPushMatrix();
		myGL.glRotatef((float) 90, 1.0f, .0f, 0.0f);
		myGL.glTranslatef(0f, 1.5f, 0.0f);
		myAUX.auxSolidCylinder(0.2, 2.2);
		myGL.glPopMatrix();

		float ambien2[] = { 1.0f, 1.0f, 0.0f, 1.0f  };
		float diff_use2[] = { 1.0f, 1.0f, 0.0f, 1.0f};
		setMaterialColor(myGL, ambien2, diff_use2);
		myGL.glPushMatrix();
		myGL.glRotatef((float) 90, 0.0f, .0f, 1.0f);
		myGL.glScalef(0.2f, 0.6f, 0.1f);
		myAUX.auxSolidBox(1.0, 7.0, 2.5);
		
		float ambien3[] = { 1.0f, 0.0f, 0.0f, 1.0f  };
		float diff_use3[] = { 1.0f, 0.0f, 0.0f, 1.0f};
		setMaterialColor(myGL, ambien3, diff_use3);
		myGL.glPushMatrix();
		myGL.glTranslatef(0f, 4.0f, -0.5f);
//		myGL.glRotatef((float) 90 , 0.0f, 1.0f, 0.0f);
		myAUX.auxSolidBox(4.0, 6.0, 1.0);
		myGL.glPopMatrix();
		myGL.glPushMatrix();
		myGL.glTranslatef(0f, -4.0f, -0.5f);
//		myGL.glRotatef((float) 90 , 0.0f, 1.0f, 0.0f);
		myAUX.auxSolidBox(4.0, 6.0, 1.0);
		myGL.glPopMatrix();
		myGL.glPopMatrix();

		
		setMaterialColor(myGL, ambien2, diff_use2);
		myGL.glPushMatrix();
		myGL.glRotatef((float) 0, 0.0f, .0f, 1.0f);
		myGL.glScalef(0.2f, 0.6f, 0.1f);
		myAUX.auxSolidBox(1.0, 7.0, 2.5);
		
		setMaterialColor(myGL, ambien3, diff_use3);
		myGL.glPushMatrix();
		myGL.glTranslatef(0f, 4.0f, -0.5f);
//		myGL.glRotatef((float) 90 , 0.0f, 1.0f, 0.0f);
		myAUX.auxSolidBox(4.0, 6.0, 1.0);
		myGL.glPopMatrix();
		myGL.glPushMatrix();
		myGL.glTranslatef(0f, -4.0f, -0.5f);
//		myGL.glRotatef((float) 90 , 0.0f, 1.0f, 0.0f);
		myAUX.auxSolidBox(4.0, 6.0, 1.0);
		myGL.glPopMatrix();
		myGL.glPopMatrix();		

		
	}

}
