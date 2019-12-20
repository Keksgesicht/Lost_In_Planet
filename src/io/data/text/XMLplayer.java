package io.data.text;

import java.io.File;

public class XMLplayer {

	File playerFile;
	File source = new File("./Game/Layouts/PlayerLayout.xml");

	public XMLplayer(File playerInfo) {
		this.playerFile = playerInfo;
	}

	public void read() {

	}	

	public void write() {

	}

	public void create(String name) {
		playerFile = new File("./Game/Characters/" + name + ".xml");
		XML.copyFile(this.source, playerFile);
	}

}
