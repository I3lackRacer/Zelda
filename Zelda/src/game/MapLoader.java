package game;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import AliveObjects.*;
import HitlessObjects.*;

public class MapLoader {

	Handler handler;

	public MapLoader(String mapName, Handler handler) {
		this.handler = handler;

		ArrayList<GameObject> map = new ArrayList<GameObject>();
		BufferedImage mapimage = null;
		try {
			mapimage = ImageIO.read(getClass().getResource("/source/" + mapName));
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (mapimage != null) {
			int baumFarbe 	= mapimage.getRGB(0, 0), 
				wasserFarbe = mapimage.getRGB(5, 0);
			for (int weite = 0; weite < mapimage.getWidth(); weite++) {
				for (int h�he = 1; h�he < mapimage.getHeight(); h�he++) {
					if (mapimage.getRGB(weite, h�he) == baumFarbe) {
						handler.addObject(new Tree(weite * 100, h�he * 100, ID.Tree, handler,(short) 1));
					}
					if(mapimage.getRGB(weite, h�he) == -1) {
						handler.addHitlessObject(new GroundPlate(weite*100, h�he*100, ID.Ground, handler, (short) 1));
					}
					if(mapimage.getRGB(weite, h�he) == wasserFarbe) {
						handler.addObject(new Water(weite*100, h�he*100, ID.Water, handler, (short) 1));
					}
				}
			}
		}
	}

}
