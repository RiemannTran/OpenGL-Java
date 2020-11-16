package model;

import jgl.GL;
import jgl.GLAUX;
import jgl.glu.GLUquadricObj;

public class Table {
	
	
	public void setMaterialColor(GL myGL,float ambien[], float diff_use[]) {
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, ambien);
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, diff_use);

	};
	
	public void display(GL myGL,GLAUX myAUX, GLUquadricObj qobj) {
		
		
		float ambienBan[] = { 1.0f, 0.8f, 0.5f, 1.0f  };
		float diff_useBan[] = { 1.0f, 1.0f, 0.3f, 1.0f};
		setMaterialColor(myGL, ambienBan, diff_useBan);	
		myAUX.auxSolidBox(5.0, 0.2, 5.0);
		
		myGL.glPushMatrix();// chan
		float ambienChan[] = { 1.0f, 1.0f, 1.0f, 1.0f  };
		float diff_useChan[] = { 1.0f, 1.0f, 1.0f, 1.0f};
		setMaterialColor(myGL, ambienChan, diff_useChan);
		myGL.glTranslated(1, -1, 1.5);
		myAUX.auxSolidCylinder(0.1, 2.0);
		myGL.glPopMatrix();
		myGL.glPushMatrix();
		myGL.glTranslated(1, -1, -1.5);
		myAUX.auxSolidCylinder(0.1, 2.0);
		myGL.glPopMatrix();
		myGL.glPushMatrix();
		myGL.glTranslated(-1, -1, -1.5);
		myAUX.auxSolidCylinder(0.1, 2.0);
		myGL.glPopMatrix();
		myGL.glPushMatrix();
		myGL.glTranslated(-1, -1, 1.5);
		myAUX.auxSolidCylinder(0.1, 2.0);
		myGL.glPopMatrix();

		

		
	}

}
