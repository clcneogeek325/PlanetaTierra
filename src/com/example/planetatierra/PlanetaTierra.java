package com.example.planetatierra;



import min3d.Shared;
import min3d.Utils;
import min3d.core.Object3dContainer;
import min3d.core.RendererActivity;
import min3d.objectPrimitives.Sphere;
import min3d.vos.Light;
import min3d.vos.TextureVo;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.view.Menu;

public class PlanetaTierra extends RendererActivity {

	
	public Object3dContainer planetatierra;
	public Object3dContainer planetamarte;
	public float velocidadtierra = (float)(Math.PI/250);
	public float velocidadmarte = (float)(Math.PI/90);
	int contadortierra = 0;
	int contadormarte = 0;

	public void initScene(){
		tierra();
//		marte();
//		contadortierra=0;
//		contadormarte=0;
	}
	public void updateScene(){
		float x_tierra = (float)(Math.sin(contadortierra%1000 * velocidadtierra) * -1.10f);
		float y_tierra = (float)(Math.cos(contadortierra%1000 * velocidadtierra) * 1.10f);
		planetatierra.position().setAll(x_tierra,y_tierra,0);
		contadortierra++;
		
//		float x_marte = (float)(Math.sin(contadormarte%360 * velocidadmarte) * -1.30f);
//		float z_marte = (float)(Math.cos(contadormarte%360 * velocidadmarte) *  2.15f);
//		planetamarte.position().setAll(x_marte,z_marte,0);
//		contadormarte++;
	
	}
	
	public void tierra(){
		//--------Texturizando una jupiter------------------------------
		
		scene.lights().add(new Light());
		planetatierra = new Sphere(.18f,16,32);
	    planetatierra.rotation().x = 90.0f;
		scene.addChild(planetatierra);
		planetatierra.texturesEnabled();

		// Create a Bitmap. Here we're generating it from an embedded resource,
		// but the Bitmap could be created in any manner (eg, dynamically).
		
		Bitmap b = Utils.makeBitmapFromResourceId(this, R.drawable.earth);
		
		// Upload the Bitmap via TextureManager and assign it a 
		// textureId ("uglysquares").
		
		Shared.textureManager().addTextureId(b, "earth", true);
		
		// Unless you have a specific reason for doing so, recycle the Bitmap,
		// as it is no longer necessary.
		
		b.recycle();

		// Create a TextureVo using the textureId that was previously added 
		// to the TextureManager ("uglysquares").
		
		TextureVo texture = new TextureVo("earth");
		
		// Add it to the TexturesList held by the Object3d, 
		// and it will be duly rendered.

		planetatierra.textures().add(texture);
				
	}

	public void marte(){
		//--------Texturizando una planetamarte------------------------------
		
		scene.lights().add(new Light());
		planetamarte = new Sphere(.18f,16,32);
		planetamarte.rotation().x = 90.0f;
		scene.addChild(planetamarte);
		planetamarte.texturesEnabled();

		// Create a Bitmap. Here we're generating it from an embedded resource,
		// but the Bitmap could be created in any manner (eg, dynamically).
		
		Bitmap b = Utils.makeBitmapFromResourceId(this, R.drawable.marte);
		
		// Upload the Bitmap via TextureManager and assign it a 
		// textureId ("uglysquares").
		
		Shared.textureManager().addTextureId(b, "marte", true);
		
		// Unless you have a specific reason for doing so, recycle the Bitmap,
		// as it is no longer necessary.
		
		b.recycle();

		// Create a TextureVo using the textureId that was previously added 
		// to the TextureManager ("uglysquares").
		
		TextureVo texture = new TextureVo("marte");
		
		// Add it to the TexturesList held by the Object3d, 
		// and it will be duly rendered.

		planetamarte.textures().add(texture);
				
	}

}
