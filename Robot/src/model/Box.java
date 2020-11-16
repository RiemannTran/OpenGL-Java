package model;

import jgl.GL;
import jgl.GLAUX;
import jgl.GLU;
import jgl.glu.GLUquadricObj;

public class Box {

	public Box() {
		// TODO Auto-generated constructor stub
	}

	public void setMaterialColor(GL myGL,float ambien[], float diff_use[]) {
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, ambien);
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, diff_use);

	};
	public void display(GL myGL,GLAUX myAUX,GLU myGLU,GLUquadricObj qobj) {
		

		float ambienBox[] = { 0.5f, 0.2f, 0.6f, 1.0f  };
		float diff_useBox[] = { 1.0f, 0.4f, 0.6f, 1.0f};
		setMaterialColor(myGL, ambienBox, diff_useBox);
		myGL.glTranslated(9.0, 0.8, -1);
		myAUX.auxSolidBox(1.5, 1.5, 1.5);
		
	}

}
