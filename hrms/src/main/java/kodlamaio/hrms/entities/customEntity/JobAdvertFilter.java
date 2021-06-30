package kodlamaio.hrms.entities.customEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertFilter {
    private List<Integer> cities;
    private List<Integer> workingTimes;
    private List<Integer> workingPlaces;
}
