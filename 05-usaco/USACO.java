import java.io.*;
import java.util.*;

public class USACO{
    
    int[][] lake;
    int[] rcen;
    int[][] stompIns;
    int volume;

    int[][] pasture, pasture2;
    int[] nmt;
    int[] startEnd;
    public USACO(){
    }

    public int bronze(String filename){
	Scanner inf = null;
	try{
	    File infile = new File(filename);
	    inf = new Scanner(infile);
	}catch (FileNotFoundException e){
	}
	
	rcen = new int[4];
	for(int index = 0; index < 4; index ++){
	    rcen[index] = inf.nextInt();
	}
	inf.nextLine();
	
	lake = new int[rcen[0]][rcen[1]];
	for(int r = 0; r < rcen[0]; r ++){	   
	    for(int c = 0; c < rcen[1]; c ++){
		lake[r][c] = inf.nextInt();
	    }
	    inf.nextLine();
	}

	stompIns = new int[rcen[3]][3];
	for(int line = 0; inf.hasNextLine(); line ++){
	    for(int i = 0; i < 3; i ++){
		stompIns[line][i] = inf.nextInt();
	    }
	    if(inf.hasNextLine()){
		inf.nextLine();
	    }
	}
	
	for(int stomps = 0; stomps < rcen[3]; stomps ++){
	    stompLake(stompIns[stomps]);
	}
	setVolume(rcen[2]);
	return volume;
    }

    private void stompLake(int[] instructions){
	int max = 0;
	int row = instructions[0];
	int col = instructions[1];
	for(int r = row - 1; r < row + 2; r ++){
	    for(int c = col - 1; c < col + 2; c ++){
		if(lake[r][c] > max){
		    max = lake[r][c];
		}
	    }
	}
	int goal = max - instructions[2];
	for (int r = row - 1; r < row + 2; r ++){
	    for(int c = col - 1; c < col + 2; c ++){
		if(lake[r][c] > goal){
		    lake[r][c] = goal;
		}
	    }
	}
    }

    private void setVolume(int elevation){
	int depth = 0;
	for(int r = 0; r < lake.length; r ++){
	    for(int c = 0; c < lake[r].length; c ++){
		if(lake[r][c] < elevation){
		    depth += elevation - lake[r][c];
		}
	    }
	}
	volume = depth * 72 * 72;
    }
    public String outString(int[][] in){
	String out = "";
	for(int r = 0; r < in.length; r ++){
	    for(int c = 0; c < in[r].length; c ++){
		out += in[r][c] + " ";
	    }
	    out += "\n";
	}
	return out;
    }

    public int silver(String filename){
	Scanner inf = null;
        try {
            File infile = new File( filename );
            inf = new Scanner(infile);
        } catch (FileNotFoundException e) {
        }

	nmt = new int[3];
	for(int index = 0; index < 3; index ++){
	    nmt[index] = inf.nextInt();
	}
	inf.nextLine();
	pasture = new int[nmt[0]][nmt[1]];
	pasture2 = new int[nmt[0]][nmt[1]];
	for(int r = 0; r < nmt[0]; r ++){
	    String line = inf.nextLine();
	    for(int c = 0; c < nmt[1]; c ++){
		if(line.charAt(c) == '*'){
		    pasture[r][c] = -1;
		    pasture2[r][c] = -1;
		}
	    }

	}

	//System.out.println(outString(pasture2));
	startEnd = new int[4];
	for(int next = 0; next < 4; next ++){
	    startEnd[next] = inf.nextInt();
	}
	updateBoard(nmt[2], startEnd[0] - 1, startEnd[1] - 1);
        //System.out.println(outString(pasture));	
	return pasture[startEnd[2] - 1][startEnd[3] - 1];
    }

    private void updateBoard(int seconds, int startr, int startc){
	if(checkPasture(startr + 1, startc)){
	    pasture[startr + 1][startc] = 1;
	}
	if(checkPasture(startr - 1, startc)){
	    pasture[startr - 1][startc] = 1;
	}
	if(checkPasture(startr, startc + 1)){
	    pasture[startr][startc + 1] = 1;
	}
	if(checkPasture(startr, startc - 1)){
	    pasture[startr][startc - 1] = 1;
	}
	for(int times = seconds - 1; times > 0; times --){
	    updateBoardH(pasture2);
	}
    }


    private boolean checkPasture(int r, int c){
	if(r > pasture.length - 1 || c > pasture[0].length - 1 || r < 0 || c < 0){
	    return false;
	}
	if(pasture[r][c] == -1){
	    return false;
	}
	return true;
    }

    private void updateBoardH(int[][] p){
	for(int r = 0; r < pasture.length; r ++){
	    for(int c = 0; c < pasture[r].length; c ++){
		if(pasture[r][c]== 0){
		    int total = 0;
		    if(checkPasture(r + 1, c)){
			total += pasture[r + 1][c];
		    }
		    if(checkPasture(r - 1, c)){
		        total += pasture[r - 1][c];
		    }
		    if(checkPasture(r, c + 1)){
		        total += pasture[r][c + 1];
		    }
		    if(checkPasture(r, c - 1)){
		        total += pasture[r][c - 1];
		    }
		    p[r][c] = total;
		}	
	    }
	}
	//System.out.println(outString(p));
	clearPasture(pasture);
	copyPasture(p);
	clearPasture(pasture2);
	//System.out.println(outString(p));
	//System.out.println(outString(pasture));
    }
    private void clearPasture(int[][] p){
        for(int r = 0; r < p.length; r ++){
	    for(int c = 0; c < p[r].length; c ++){
		if(p[r][c] != -1){
		    p[r][c] = 0;
		}
	    }
	}
    }
    private void copyPasture(int[][] p){
        for(int r = 0; r < p.length; r ++){
	    for(int c = 0; c < p[r].length; c ++){
		if(p[r][c] != -1){
		    pasture[r][c] = p[r][c];
		}
	    }
	}
    }
    public static void main(String[]args){
	USACO x = new USACO();

	//System.out.println(x.bronze("test.txt"));
	System.out.println(x.silver("test2.txt"));
    }
}
