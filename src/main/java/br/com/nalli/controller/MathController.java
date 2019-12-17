package br.com.nalli.controller;

import org.springframework.web.bind.annotation.*;
import br.com.nalli.converter.NumberConverter;
import br.com.nalli.mathoperation.MathOperation;

@RestController
public class MathController {
    private NumberConverter convert = new NumberConverter();
    private MathOperation operator = new MathOperation();
    
    @RequestMapping(value="/sum/{numberOne}/{numberTwo}",method= RequestMethod.GET )
    public Double sum(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!convert.isNumeric(numberOne) || !convert.isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please Set numeric value.");
    }        
        double result = operator.sum(convert.convertToDouble(numberOne),convert.convertToDouble(numberTwo));
        return result;
    }

    @RequestMapping(value="/sub/{numberOne}/{numberTwo}",method= RequestMethod.GET )
    public Double sub(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!convert.isNumeric(numberOne) || !convert.isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please Set numeric value.");
        }
        Double result = operator.subtraction(convert.convertToDouble(numberOne),convert.convertToDouble(numberTwo));
        return result;
    }

    @RequestMapping(value="/div/{numberOne}/{numberTwo}",method= RequestMethod.GET )
    public Double div(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!convert.isNumeric(numberOne) || !convert.isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please Set numeric value.");
        }
        Double result = operator.division(convert.convertToDouble(numberOne),convert.convertToDouble(numberTwo));
        return result;
    }

    @RequestMapping(value="/media/{numberOne}/{numberTwo}",method= RequestMethod.GET )
    public Double media(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!convert.isNumeric(numberOne) || !convert.isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please Set numeric value.");
        }
        Double result = operator.media(convert.convertToDouble(numberOne),convert.convertToDouble(numberTwo));
        return result;
    }
    
    @RequestMapping(value="/multiplication/{numberOne}/{numberTwo}",method= RequestMethod.GET )
    public Double multiplication(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!convert.isNumeric(numberOne) || !convert.isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please Set numeric value.");
        }
        Double result = operator.multiplication(convert.convertToDouble(numberOne),convert.convertToDouble(numberTwo));
        return result;
    }

    @RequestMapping(value="/squareRoot/{numberOne}",method= RequestMethod.GET )
    public Double raiz(@PathVariable("numberOne") String numberOne) throws Exception {
        if (!convert.isNumeric(numberOne)){
            throw new UnsupportedOperationException("Please Set numeric value.");
        }
        Double result =  operator.squareRoot(convert.convertToDouble(numberOne));
        return result;
    }

}
