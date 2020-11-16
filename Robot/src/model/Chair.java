package model;

import jgl.GL;
import jgl.GLAUX;
import jgl.GLU;
import jgl.glu.GLUquadricObj;

public class Chair {


	public void setMaterialColor(GL myGL,float ambien[], float diff_use[]) {
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, ambien);
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, diff_use);

	};
	public void display(GL myGL,GLAUX myAUX,GLU myGLU,GLUquadricObj qobj) {
		
		float ambienChan[] = { 1.0f, 1.0f, 0.2f, 1.0f  };
		float diff_useChan[] = { 1.0f, 1.0f, 0.3f, 1.0f};
		setMaterialColor(myGL, ambienChan, diff_useChan);
		myGL.glPushMatrix();//ngoi
		myGL.glTranslated(0, 1.3, -0.5);
		myAUX.auxSolidBox(2.0, 0.2, 2.0);
		myGL.glPopMatrix();

		float ambienChanTua[] = { 0.2f, 0.8f, 0.2f, 1.0f };
		float diff_useChanTua[] = { 0.2f, 0.7f, 0.3f, 1.0f};
		setMaterialColor(myGL, ambienChanTua, diff_useChanTua);
		myGL.glPushMatrix();
		myGL.glTranslated(-0.5, 2.0, -1.0);
		myAUX.auxSolidBox(0.2, 1.5, 0.2);
		myGL.glPopMatrix();
		
		myGL.glPushMatrix();
		myGL.glTranslated(0, 2.5, -1.0);
		myAUX.auxSolidBox(1.2, 0.2, 0.2);
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glTranslated(0.5, 2.0, -1.0);
		myAUX.auxSolidBox(0.2, 1.5, 0.2);
		myGL.glPopMatrix();
		
		
		float ambienTua[] = { 1.0f, 1.0f, 0.2f, 1.0f };
		float diff_useTua[] = { 1.0f, 1.0f, 0.3f, 1.0f};
		setMaterialColor(myGL, ambienTua, diff_useTua);
		myGL.glPushMatrix();// tua
		myGL.glTranslated(0.0, 2.5, -0.9);
		myAUX.auxSolidBox(2.0, 1.5, 0.2);
		myGL.glPopMatrix();

		float ambienChanChong[] = { 0.2f, 0.5f, 0.2f, 1.0f };
		float diff_useChanChong[] = { 0.2f, 0.7f, 0.3f, 1.0f};
		setMaterialColor(myGL, ambienChanChong, diff_useChanChong);
		myGL.glPushMatrix();
		myGL.glTranslated(-0.5, 0.2, 0);
		myAUX.auxSolidCylinder(0.1, 1.8);
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glTranslated(-0.5, 0.2, -1.0);
		myAUX.auxSolidCylinder(0.1, 1.8);
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glTranslated(0.5, 0.2, -1.0);
		myAUX.auxSolidCylinder(0.1, 1.8);
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glTranslated(0.5, 0.2, 0);
		myAUX.auxSolidCylinder(0.1, 1.8);
		myGL.glPopMatrix();

		
	}

}
