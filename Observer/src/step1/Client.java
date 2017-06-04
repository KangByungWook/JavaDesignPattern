/* 상황
 * : 성적이 입력된 후 입력된 성적을 포함하여 몇개의 성적을들 display해주는 기능을 구현.
 * */
package step1;

import java.util.ArrayList;
import java.util.List;

// 정보를 저장하는 클래스.
class ScoreRecord{
	private List<Integer> scores = new ArrayList<Integer>();	// 점수를 저장할 공간.
	private DataSheetView dataSheetView; // 목록 형태로 점수를 출력하는 클래스.
	
	public void setDataSheetView(DataSheetView dataSheetView){
		this.dataSheetView = dataSheetView;
	}
	
	public void addScore(int score){	// 새로운 점수를 추가함.
		scores.add(score);		// scores 목록에 주어진 점수를 추가함.
		dataSheetView.update();	// score가 변경됨을 통보.
	}
	
	public List<Integer> getScoreRecord(){
		return scores;
	}
}

class DataSheetView {
	private ScoreRecord scoreRecord;
	private int viewCount;
	
	public DataSheetView(ScoreRecord scoreRecord, int viewCount){
		this.scoreRecord = scoreRecord;
		this.viewCount = viewCount;
	}
	
	public void update() {	// 점수의 변경을 통보받음.
		List<Integer> record = scoreRecord.getScoreRecord();	// 점수를 조회.
		displayScores(record, viewCount);					// 조회된 점수를 viewCount 만큼 출력..
	}
	
	private void displayScores(List<Integer> record, int viewCount){
		System.out.println("List of " + viewCount + " entries: ");
		for(int i = 0; i < viewCount && i < record.size(); i++){
			System.out.println(record.get(i) + " ");
		}
		System.out.println();
	}
}

public class Client {

	public static void main(String[] args) {
		ScoreRecord scoreRecord = new ScoreRecord();
		
		// 3개까지의 점수만 출력
		DataSheetView dataSheetView = new DataSheetView(scoreRecord, 3);
		
		scoreRecord.setDataSheetView(dataSheetView);
		
		for(int index = 1 ; index <= 5; index++){
			int score =  index * 10;
			System.out.println("Adding " + score);
			
			// 10 20 30 40 50을 추가함, 추가할 때마다 최대 3개의 점수만 출력.
			scoreRecord.addScore(score);
		}

	}

}
