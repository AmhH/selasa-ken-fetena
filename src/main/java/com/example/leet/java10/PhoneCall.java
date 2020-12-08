package com.example.leet.java10;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class PhoneCall {
  private long id;
  private String phoneNumber;
  private LocalDateTime dateStart;
  private LocalDateTime dateEnd;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public LocalDateTime getDateStart() {
    return dateStart;
  }

  public void setDateStart(LocalDateTime dateStart) {
    this.dateStart = dateStart;
  }

  public LocalDateTime getDateEnd() {
    return dateEnd;
  }

  public void setDateEnd(LocalDateTime dateEnd) {
    this.dateEnd = dateEnd;
  }

  public long maximumConcurrentCalls(List<PhoneCall> phoneCalls){
    long count = 0;
    if(phoneCalls != null && phoneCalls.size() > 1){
      phoneCalls.sort(Comparator.comparing(PhoneCall::getDateStart).thenComparing(PhoneCall::getDateEnd));

      LocalDateTime start = phoneCalls.get(0).getDateStart();
      LocalDateTime end = phoneCalls.get(0).getDateEnd();

      for (int i = 1; i < phoneCalls.size(); i++) {
        if(end.isAfter(phoneCalls.get(i).getDateStart())){
          count++;
          end = end.isAfter(phoneCalls.get(i).getDateEnd()) ? end : phoneCalls.get(i).getDateEnd();
        }else{
          end = phoneCalls.get(i).getDateEnd();
        }
      }
    }
    return count;
  }

}
