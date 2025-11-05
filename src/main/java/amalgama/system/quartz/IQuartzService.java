package amalgama.system.quartz;

import org.quartz.JobDetail;

public interface IQuartzService {
    JobDetail addJobInterval(String name, String group, IQuartzJob job, TimeUnit timeUnit, long time);
    JobDetail addJobInterval(String name, String group, IQuartzJob job, TimeUnit timeUnit, long time, int paramInt);
    JobDetail addJob(String name, String group, IQuartzJob job, TimeUnit timeUnit, long time);
    void deleteJob(String name, String group);
}
