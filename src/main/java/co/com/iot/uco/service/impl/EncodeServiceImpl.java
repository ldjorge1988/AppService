package co.com.iot.uco.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EncodeServiceImpl {

    private final PasswordEncoder bcryptEncoder;
    
    

    public String encodeData(String data){
        return bcryptEncoder.encode(data);
    }

    
}
