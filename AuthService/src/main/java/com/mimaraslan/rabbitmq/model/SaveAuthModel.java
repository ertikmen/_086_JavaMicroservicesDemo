package com.mimaraslan.rabbitmq.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveAuthModel implements Serializable {

    private   Long authid;
    private   String username;
    private   String email;
}
