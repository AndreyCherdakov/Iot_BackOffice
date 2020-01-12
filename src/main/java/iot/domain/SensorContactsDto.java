package main.java.iot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class SensorContactsDto {

    private int sensorId;
    private String email;
    private String phone;
    private String endPoint;

}
