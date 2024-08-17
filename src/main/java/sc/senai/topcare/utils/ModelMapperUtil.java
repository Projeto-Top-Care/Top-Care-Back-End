package sc.senai.topcare.utils;

import org.modelmapper.ModelMapper;

public class ModelMapperUtil {
    public static void map(Object mapped, Object destination){
        new ModelMapper().map(mapped, destination);
    }
}
