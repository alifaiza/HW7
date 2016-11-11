import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationMain {
	public static ArrayList<Monster> listMonsters(File file) throws FileNotFoundException {
		ArrayList<Monster> monsters = new ArrayList<Monster>();
		String monster = null;
		String type = null;
		String level = null;
		String treasure = null;
		Scanner scan = new Scanner(file);
		scan.useDelimiter("\t");
		int index = 0;
		while (scan.hasNext()) {
			index++;
			if (index == 1) {
				monster = scan.next();
				System.out.println(monster);
			}
			else if (index == 2) {
				type = scan.next();
			}
			else if (index == 3) {
				level = scan.next();
			}
			else if (index == 4) {
				treasure = scan.next();
				index = 0;
				monsters.add(new Monster(monster, type, level, treasure));
			}
		}
		scan.close();
		return monsters;
	}
	

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("/home/alifaiza/workspace/hw7/src/data/large/monstats.txt");
		ArrayList<Monster> monsters = listMonsters(file);
		for (Monster mon : monsters) {
			System.out.println(mon.monsterClass);
			System.out.println(mon.type);
			System.out.println(mon.level);
			System.out.println(mon.treasure);
		}
	}
}
