package ex04_join;

public class Calculator implements Runnable {
	
	private long total;		// 필드로 옮기면 = 0는 삭제해도 된다. 이미 0이기 떄문에
	private long begin;
	private long end;
	
	public Calculator(long begin, long end) {
		this.begin = begin;
		this.end = end;
	}
	
	
	public void add() {
		for(long n = begin; n <= end; n++) {
			total += n;							// begin 부터 end 사이에 있는 모든 수를 더함.(반복문)
		}
	}


	public long getTotal() {		// get&setter
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}

	@Override
	public void run() {
		add();	// add메소드 호출만 해주면 됨
		
	}	
}
