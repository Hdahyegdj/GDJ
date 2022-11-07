package batch;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import domain.Free;
import repository.FreeDao;

public class FreeJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		List<Free> job = FreeDao.getInstance().selectFreeJob();

		for(Free f : job) {
			System.out.println(f.getFreeNo() + f.getWriter() + f.getTitle() + f.getIp() + f.getHit() + f.getContent());
		}

	}

}
