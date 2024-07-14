package sg.nus.iss.javaspring.minicoins;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class Controller {


    @PostMapping("/submit")
    public List<Double> getCoinDenomination (@RequestBody Submission submission) {

        double input = Double.parseDouble(submission.getInputValue());
        double[] coins = submission.getSelectedCoins();
        List<Double> output = new ArrayList<>();
        Map<Double,Integer> results = new HashMap<Double,Integer>();
        if(input>1000||input<0){
            return null;
        }
        for(int i = coins.length - 1; i >= 0; i--) {
            if(input>=coins[i]){
                results.put(coins[i],(int)Math.floor(input/coins[i]));
                input = input-coins[i]*results.get(coins[i]);
            }
            input = Math.round(input * 100.0) / 100.0;
        }
        if(input>0)
            return null;
        else{

            output = convertMapToList(results);
            return output;
        }


    }

    public static List<Double> convertMapToList(Map<Double, Integer> map) {
        List<Double> list = new ArrayList<>();
        for (Map.Entry<Double, Integer> entry : map.entrySet()) {
            Double key = entry.getKey();
            Integer value = entry.getValue();
            for (int i = 0; i < value; i++) {
                list.add(key);
            }
        }
        return list;
    }
}
