package com.bootcamp.demo.bc_mtr_station.config;

// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
// import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AppScheduler {

  // // fixedDelay  -> count 2 seconds right after task completed
  // // fixedRate -> if actual schedule behind the target schedule, it will try to catch up
  // @Scheduled(fixedDelay = 2000L) // 2000 ms -> 2 seconds
  // public void sayHello() throws InterruptedException {
  //   // Get current time
  //   LocalDateTime now = LocalDateTime.now();

  //   // Define a custom format
  //   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
  //   // Format the LocalDateTime
  //   String formattedDateTime = now.format(formatter);

  //   // Print current time and say Hello
  //   System.out.println("\n[Scheduler: " + formattedDateTime + "] -> Hello!\n");

  //   // Make thread sleep for 3 seconds
  //   Thread.sleep(3000L);
  // }



  // // Cron Job
  // @Scheduled(cron = "0 29 16 * * THU")
  // public void testThursday() {
  //   LocalDateTime now = LocalDateTime.now();
  //   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
  //   String formattedDateTime = now.format(formatter);

  //   System.out.println("\n [Cron: " + formattedDateTime + "] Hello Thursday!!! \n");
  // }


  
}
