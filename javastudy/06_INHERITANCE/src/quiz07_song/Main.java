package quiz07_song;

public class Main {

	public static void main(String[] args) {
		
		
		Singer singer = new Singer("가수", 2);   // 선미의 노래가 2개다.

		Song song1 = new Song("노래1", 3.5);
		Song song2 = new Song("노래2", 4.5);
		
		Producer producer = new Producer();
		producer.produce(singer, song1);		// producer가 가수에게 노래1을 준다.
		producer.produce(singer, song2);
		
		singer.info();
		
	}

}
