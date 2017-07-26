package com.techolution.service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import com.techolution.dto.Satisfaction;
import com.techolution.util.FileUtil;

/**
 * Service is responsible to find satisfaction level of customer.
 * @author Chandan Behera
 */

public class SatisfactionService {

	@Autowired
	private FileUtil fileUtil;
	
	
	public Satisfaction findSatisfaction(){
		Satisfaction customerSatisfaction = new Satisfaction();
		Map<Integer, Integer> fileMap = fileUtil.getFileMap();
		
		/*
		 *  Find satisfaction of customer per unit of time 
		 *  Customer getting x1 satisfaction by consuming t1 unit of time for I1 item and so on for other items 
		 *  Find the satisfaction will achieve by consume per unit of time = x1/t1, x1/t2 . . . 
		 */
		  Map<Object, Integer> satisfactionMap = fileMap.entrySet().stream()
	                .collect(Collectors.toMap(p -> p.getKey(), p -> (p.getKey()/p.getValue())));
		  	  
		  /*
		   * There should be a situation where customer will get maximum satisfaction by consuming less time,
		   * get that data.
		   */
		  Map<Object, Integer> satisfactionSortedMap = new LinkedHashMap<>();
		  satisfactionMap.entrySet().stream()
	                .sorted(Map.Entry.<Object, Integer>comparingByValue().reversed())
	                .forEachOrdered(x -> satisfactionSortedMap.put(x.getKey(), x.getValue()));

	      /*
	       * Find the total satisfaction the customer will get  within provided time.
	       * There might be scenario where consumer can't utilize 100% time in that scenario we can find out 
	       * per unit consumption time so that consume can utilize 100% time.
	       */
	      Integer totalTime = fileMap.entrySet().iterator().next().getKey();
	      Integer timeConsumed = 0;
	      Integer totalSatisfaction = 0;
	      Map<Object, Integer> satisfactionPerUnit = new LinkedHashMap<>();
	      for (Map.Entry<Object, Integer> entry : satisfactionSortedMap.entrySet()) {
	    		  Integer timePerUnit = fileMap.get(entry.getKey());
	    		  totalTime -= timePerUnit;
	    		  if(totalTime < 1)
		    	  		break;
	    		  satisfactionPerUnit.put(entry.getKey(), fileMap.get(entry.getKey()));
	    		  totalSatisfaction +=  (Integer) entry.getKey();
	    		  timeConsumed += fileMap.get(entry.getKey());
	    }
	      customerSatisfaction.setSatisfactionPerUnit(satisfactionPerUnit);
	      customerSatisfaction.setTotalSatisfaction(totalSatisfaction.toString());
	      customerSatisfaction.setTotalTimeConsumed(timeConsumed.toString());
	      return customerSatisfaction;
	}
}
