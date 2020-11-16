package model;

import jgl.GL;
import jgl.GLAUX;

public class Human {

	public void setMaterialColor(GL myGL, float ambien[], float diff_use[]) {
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, ambien);
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, diff_use);

	};

	public void display(GL myGL, GLAUX myAUX, int legRight, int legLeft, int shoulderRight, int shoulderLeft,
			int body) {

		myGL.glPushMatrix();// body

		myGL.glRotatef((float) body, 0.0f, 1.0f, 0.0f);

		myGL.glPushMatrix();

		float ambienBody[] = { 0.0f, 1.0f, 0.2f, 1.0f };
		float diff_useBody[] = { 0.2f, 1.0f, 0.6f, 1.0f };
		setMaterialColor(myGL, ambienBody, diff_useBody);
		myGL.glTranslatef(0.0f, 0.2f, 0.0f);
		myGL.glScalef(0.75f, 3.5f, 0.15f);
		myAUX.auxSolidBox(2.2, 0.3, 8.0);
		myGL.glPopMatrix();

		myGL.glPushMatrix();// chest1
		float ambienNguc[] = { 0.8f, 0.5f, 0.2f, 1.0f };
		float diff_useNguc[] = { 0.8f, 1.0f, 0.6f, 1.0f };
		setMaterialColor(myGL, ambienNguc, diff_useNguc);
		myGL.glTranslatef(-0.6f, 1.6f, 0.3f);
		myGL.glScalef(0.75f, 3.5f, 0.15f);
		myAUX.auxSolidBox(1.2, 0.3, 8.0);
		myGL.glPopMatrix();

		myGL.glPushMatrix();// chest2
		myGL.glTranslatef(0.6f, 1.6f, 0.3f);
		myGL.glScalef(0.75f, 3.5f, 0.15f);
		myAUX.auxSolidBox(1.2, 0.3, 8.0);
		myGL.glPopMatrix();

		myGL.glPushMatrix();// chest3
		myGL.glTranslatef(0.0f, 1.5f, 0.3f);
		myGL.glScalef(0.75f, 2.0f, 0.15f);
		myAUX.auxSolidBox(0.1, 0.8, 8.0);
		myGL.glPopMatrix();

		float ambienN[] = { 0.8f, 0.9f, 0.5f, 1.0f };
		float diff_useN[] = { 0.5f, 1.0f, 0.6f, 1.0f };
		setMaterialColor(myGL, ambienN, diff_useN);
		myGL.glPushMatrix();
		myGL.glTranslatef(0.0f, 1.5f, 0.0f);
		myGL.glScalef(0.75f, 2.0f, 0.2f);
		myAUX.auxSolidBox(3.0, 1.0, 8.0);
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glScalef(2.0f, 2.0f, 2.0f);
		myGL.glTranslatef(0.7f, 1.2f, 0.0f);
		myGL.glScalef(1.0f, 1.0f, 0.25f);
		myAUX.auxSolidBox(0.3, 0.3, 2.0);
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glScalef(2.0f, 2.0f, 2.0f);
		myGL.glTranslatef(-0.7f, 1.2f, 0.0f);
		myGL.glScalef(1.0f, 1.0f, 0.25f);
		myAUX.auxSolidBox(0.3, 0.3, 2.0);
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		float ambienNgucMa[] = { 0.0f, 0.0f, 0.0f, 1.0f };
		float diff_useNgucMa[] = { 0.8f, 0.2f, 0.6f, 1.0f };
		setMaterialColor(myGL, ambienBody, diff_useBody);
		myGL.glScalef(2f, 2f, 2f);
		myGL.glTranslatef(0.0f, 1.7f, 0.0f);
		myGL.glScalef(0.5f, 0.5f, 0.5f);
		myAUX.auxSolidBox(1.25, 1.5, 1.0);
		myGL.glPushMatrix();
		setMaterialColor(myGL, ambienNgucMa, diff_useNgucMa);
		myGL.glTranslatef(0.0f, 0.1f, 0.3f);
		myAUX.auxSolidBox(0.1, 0.8, 0.5);
		myGL.glPopMatrix();
		myGL.glPushMatrix();
		float ambienNgucM[] = { 1.0f, 0.1f, 0.7f, 1.0f };
		float diff_useNgucM[] = { 1.0f, 0.0f, 0.6f, 1.0f };
		setMaterialColor(myGL, ambienNgucM, diff_useNgucM);
		myGL.glTranslatef(0.0f, -0.6f, 0.3f);
		myAUX.auxSolidBox(0.7, 0.2, 0.5);
		myGL.glPopMatrix();
		myGL.glPushMatrix();
		
		setMaterialColor(myGL, ambienNgucMa, diff_useNgucMa);
		myGL.glTranslatef(-0.5f, 0.25f, 0.7f);
		myAUX.auxSolidSphere(0.2);
		myGL.glPopMatrix();
		float ambienNgucMa1[] = { 0.6f, 0.1f, 0.7f, 1.0f };
		float diff_useNgucMa1[] = { 0.8f, 1.0f, 0.6f, 1.0f };
		setMaterialColor(myGL, ambienNgucMa1, diff_useNgucMa1);
		myGL.glTranslatef(-0.5f, 0.25f, 0.2f);
		myAUX.auxSolidBox(0.5, 0.5, 1.0);
		myGL.glTranslatef(1.0f, 0.0125f, 0.0f);
		myAUX.auxSolidBox(0.5, 0.5, 1.0);
		myGL.glPushMatrix();
		float ambienNgucMa2[] = { 0.0f, 0.0f, 0.0f, 1.0f };
		float diff_useNgucMa2[] = { 0.8f, 0.2f, 0.6f, 1.0f };
		setMaterialColor(myGL, ambienNgucMa2, diff_useNgucMa2);
		myGL.glTranslatef(0.0125f, 0.0125f, 0.5f);
		myAUX.auxSolidSphere(0.2);
		myGL.glPopMatrix();
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		setMaterialColor(myGL, ambienN, diff_useN);
		myGL.glScalef(1.8f, 2.0f, 2f);
		myGL.glTranslatef(0.95f, 1.3f, 0.0f);
		myGL.glRotatef(shoulderRight, 1.0f, 0.0f, 0.0f);
		myGL.glRotatef(90, 0.0f, 0.0f, 1.0f);
		myAUX.auxSolidSphere(0.2);
		myGL.glTranslatef(0.5f, 0.0f, 0.0f);
		myAUX.auxSolidBox(0.8, 0.4, 0.5); /* shoulder */
		setMaterialColor(myGL, ambienBody, diff_useBody);
		myGL.glTranslatef(0.5f, 0.0f, 0.0f);
		myAUX.auxSolidSphere(0.2);
		myGL.glTranslatef(0.5f, 0.0f, 0.0f);
		myAUX.auxSolidBox(0.8, 0.4, 0.5); /* elbow */
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		setMaterialColor(myGL, ambienN, diff_useN);
		myGL.glScalef(1.8f, 2.0f, 2f);
		myGL.glTranslatef(-0.95f, 1.3f, 0.0f);
		myGL.glRotatef(shoulderLeft, 1.0f, 0.0f, 0.0f);
		myGL.glRotatef(90, 0.0f, 0.0f, 1.0f);
		myAUX.auxSolidSphere(0.2);
		myGL.glTranslatef(-0.5f, 0.0f, 0.0f);
		myAUX.auxSolidBox(0.8, 0.4, 0.5); /* shoulder */
		setMaterialColor(myGL, ambienBody, diff_useBody);
		myGL.glTranslatef(-0.5f, 0.0f, 0.0f);
		myAUX.auxSolidSphere(0.2);
		myGL.glTranslatef(-0.5f, 0.0f, 0.0f);
		myAUX.auxSolidBox(0.8, 0.4, 0.5); /* elbow */
		myGL.glPopMatrix();

		myGL.glPopMatrix();// body

		myGL.glPushMatrix();// hang
		setMaterialColor(myGL, ambienN, diff_useN);
		myGL.glColor3f(0.2f, 0.2f, 0.3f);
		myGL.glTranslatef(0.0f, -0.3f, 0.0f);
		myGL.glScalef(1.0f, 1.0f, 0.25f);
		myAUX.auxSolidBox(1.0, 1.3, 3.5);
		myGL.glPopMatrix();

		myGL.glPushMatrix();// foot right
		float ambienf[] = { 0.8f, 0.8f, 0.2f, 1.0f };
		float diff_usef[] = { 0.8f, 0.8f, 0.2f, 1.0f };
		setMaterialColor(myGL, ambienN, diff_useN);
		myGL.glRotatef(legRight, 1.0f, 0.0f, 0.0f);
		myGL.glPushMatrix();
		myGL.glTranslatef(0.5f, -1f, 0.0f);
		myAUX.auxSolidSphere(0.5);
		myGL.glPopMatrix();
		myGL.glRotatef(-90, 0.0f, 0.0f, 1.0f);
		myGL.glTranslatef(2.0f, 0.6f, 0.0f);
		myAUX.auxSolidBox(1.8, 1.0, 1.0);
		setMaterialColor(myGL, ambienBody, diff_useBody);
		myGL.glTranslatef(1.0f, 0.005f, 0.0f);
		myAUX.auxSolidSphere(0.5);
		myGL.glTranslatef(1.5f, 0.0f, 0.0f);
		myAUX.auxSolidBox(2.5, 1.0, 1.0);
		myGL.glTranslatef(1.6f, 0f, 0.3f);
		setMaterialColor(myGL, ambienf, diff_usef);
		myAUX.auxSolidBox(1, 1.0, 1.6);
		myGL.glPopMatrix();

		myGL.glPushMatrix();// foot left
		setMaterialColor(myGL, ambienN, diff_useN);
		myGL.glRotatef(legLeft, 1.0f, 0.0f, 0.0f);
		myGL.glPushMatrix();
		myGL.glTranslatef(-0.5f, -1f, 0.0f);
		myAUX.auxSolidSphere(0.5);
		myGL.glPopMatrix();
		myGL.glRotatef(90, 0.0f, 0.0f, 1.0f);
		myGL.glTranslatef(-2.0f, 0.6f, 0.0f);
		myAUX.auxSolidBox(1.8, 1.0, 1.0);
		setMaterialColor(myGL, ambienBody, diff_useBody);
		myGL.glTranslatef(-1.0f, 0.005f, 0.0f);
		myAUX.auxSolidSphere(0.5);
		myGL.glTranslatef(-1.5f, 0.0f, 0.0f);
		myAUX.auxSolidBox(2.5, 1.0, 1.0);
		myGL.glTranslatef(-1.6f, 0f, 0.3f);
		setMaterialColor(myGL, ambienf, diff_usef);
		myAUX.auxSolidBox(1, 1.0, 1.6);
		myGL.glPopMatrix();

		myGL.glPopMatrix();// body

	}

}
