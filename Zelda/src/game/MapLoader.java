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
				for (int höhe = 1; höhe < mapimage.getHeight(); höhe++) {
					if (mapimage.getRGB(weite, höhe) == baumFarbe) {
						handler.addObject(new Tree(weite * 100, höhe * 100, ID.Tree, handler,(short) 1));
					}
					if(mapimage.getRGB(weite, höhe) == -1) {
						handler.addHitlessObject(new GroundPlate(weite*100, höhe*100, ID.Ground, handler, (short) 1));
					}
					if(mapimage.getRGB(weite, höhe) == wasserFarbe) {
						handler.addObject(new Water(weite*100, höhe*100, ID.Water, handler, (short) 1));
					}
				}
			}
		}
	}

}
