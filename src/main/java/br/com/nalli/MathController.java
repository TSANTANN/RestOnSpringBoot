package br.com.nalli;

import org.springframework.web.bind.annotation.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/sum/{numberOne}/{numberTwo}",method= RequestMethod.GET )
    public Double sum(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please Set numeric value.");
    }
        Double sum = convertToDouble(numberOne) +  convertToDouble(numberTwo);
        return sum;
    }

    @RequestMapping(value="/sub/{numberOne}/{numberTwo}",method= RequestMethod.GET )
    public Double sub(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please Set numeric value.");
        }
        Double sub = convertToDouble(numberOne) -  convertToDouble(numberTwo);
        return sub;
    }

    @RequestMapping(value="/div/{numberOne}/{numberTwo}",method= RequestMethod.GET )
    public Double div(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please Set numeric value.");
        }
        Double div = convertToDouble(numberOne) /  convertToDouble(numberTwo);
        return div;
    }

    @RequestMapping(value="/media/{numberOne}/{numberTwo}",method= RequestMethod.GET )
    public Double media(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please Set numeric value.");
        }
        Double media = (convertToDouble(numberOne) +  convertToDouble(numberTwo))/2;
        return media;
    }

    @RequestMapping(value="/raiz/{numberOne}",method= RequestMethod.GET )
    public Double raiz(@PathVariable("numberOne") String numberOne) throws Exception {
        if (!isNumeric(numberOne)){
            throw new UnsupportedOperationException("Please Set numeric value.");
        }
        Double raiz = Math.sqrt(convertToDouble(numberOne)) ;
        return raiz;
    }

    private double convertToDouble(String strNumber) {
        if(strNumber==null) return 0;
        String number = strNumber.replaceAll(",",".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0;
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber==null) return false;
        String number = strNumber.replaceAll(",",".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
