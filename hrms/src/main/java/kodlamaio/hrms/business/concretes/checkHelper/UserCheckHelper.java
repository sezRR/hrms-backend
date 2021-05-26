package kodlamaio.hrms.business.concretes.checkHelper;

import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

import java.util.List;

public class UserCheckHelper {
    public static Result checkLogicResults(List<Result> logicResults){
        StringBuilder message = new StringBuilder();

        int errorCounter = 0;

        for (var result : logicResults){
            if (result != null){
                message.append(result.getMessage()).append(" ");
                errorCounter++;
            }
        }

        if (errorCounter > 0){
            return new ErrorResult(message.toString());
        }

        return new SuccessResult(Messages.validationSuccess);
    }
}
