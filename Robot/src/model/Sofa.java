package model;

import jgl.GL;
import jgl.GLAUX;
import jgl.GLU;
import jgl.glu.GLUquadricObj;

public class Sofa {

	public Sofa() {
		// TODO Auto-generated constructor stub
	}

	public void setMaterialColor(GL myGL,float ambien[], float diff_use[]) {
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, ambien);
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, diff_use);

	};
	public void display(GL myGL,GLAUX myAUX,GLU myGLU,GLUquadricObj qobj) {
		
		float ambienChan[] = { 1.0f, 0.2f, 0.4f, 1.0f  };
		float diff_useChan[] = { 1.0f, 0.4f, 0.6f, 1.0f};
		setMaterialColor(myGL, ambienChan, diff_useChan);
		myGL.glPushMatrix();// ngoisofa
		myAUX.auxSolidBox(3, 0.8, 6);
		myGL.glPopMatrix();
		
		float ambienNgoi[] = { 0.2f, 0.8f, 0.4f, 1.0f  };
		float diff_useNgoi[] = { 0.2f, 0.4f, 0.6f, 1.0f};
		setMaterialColor(myGL, ambienNgoi, diff_useNgoi);
		myGL.glPushMatrix();// ngoisofa
		myGL.glTranslated(-0.2, 0.5, 0);
		myAUX.auxSolidBox(2, 0.2, 5);
		myGL.glPopMatrix();
		
		float ambienTua[] = { 1.0f, 0.2f, 0.4f, 1.0f  };
		float diff_useTua[] = { 1.0f, 0.4f, 0.6f, 1.0f};
		setMaterialColor(myGL, ambienTua, diff_useTua);
		myGL.glPushMatrix();// tuasofa
		myGL.glTranslated(1.0, 1.0, 0);
		myAUX.auxSolidBox(1.0, 2.0, 6);
		myGL.glPopMatrix();

		
	}

}
