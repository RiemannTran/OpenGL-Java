package model;

import jgl.GL;
import jgl.GLAUX;
import jgl.GLU;
import jgl.glu.GLUquadricObj;

public class Wardrobe {

	public Wardrobe() {
		// TODO Auto-generated constructor stub
	}
	

	public void setMaterialColor(GL myGL,float ambien[], float diff_use[]) {
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, ambien);
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, diff_use);

	};
	public void display(GL myGL,GLAUX myAUX,GLU myGLU,GLUquadricObj qobj) {
		
		float ambienBox[] = { 1.0f, 0.2f, 0.4f, 1.0f };
		float diff_useBox[] = { 1.0f, 0.4f, 0.6f, 1.0f };
		setMaterialColor(myGL, ambienBox, diff_useBox);
		myGL.glPushMatrix();
		myGL.glTranslated(1.0, 0.0, 0.7);
		myAUX.auxSolidBox(1.8, 4, 1);
		myGL.glPopMatrix();
		
		float ambienNam[] = { 1.0f, 1.0f, 1.0f, 1.0f };
		float diff_useNam[] = { 1.0f, 1.0f, 1.0f, 1.0f };
		setMaterialColor(myGL, ambienNam, diff_useNam);
		myGL.glPushMatrix();
		myGL.glTranslated(0.5, 0.2, 1.2);
		myAUX.auxSolidBox(0.2, 0.2, 0.3);
		myGL.glPopMatrix();
		
		float ambienNam1[] = { 1.0f, 1.0f, 1.0f, 1.0f };
		float diff_useNam1[] = { 1.0f, 1.0f, 1.0f, 1.0f };
		setMaterialColor(myGL, ambienNam1, diff_useNam1);
		myGL.glPushMatrix();
		myGL.glTranslated(-0.5, 0.2, 1.2);
		myAUX.auxSolidBox(0.2, 0.2, 0.3);
		myGL.glPopMatrix();
		
		float ambienThung[] = { 1.0f, 0.2f, 0.4f, 1.0f  };
		float diff_useThung[] = { 1.0f, 0.4f, 0.6f, 1.0f};
		setMaterialColor(myGL, ambienThung, diff_useThung);
		myGL.glPushMatrix();
		myGL.glTranslated(-1.0, 0.0, 0.7);
		myAUX.auxSolidBox(1.8, 4, 1);
		myGL.glPopMatrix();
		
		float ambienTo[] = { 0.5f, 1.0f, 0.0f, 1.0f };
		float diff_useTo[] = { 1.0f, 1.0f, 0.6f, 1.0f };
		setMaterialColor(myGL, ambienTo, diff_useTo);
		myAUX.auxSolidBox(4, 5, 2);

		
	}

}
