package com.gopher.zkd1.config;

import com.gopher.zkd1.tk.CoreMapper;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author 6c6763
 * @date 2020/10/22
 */
public class TkFilterConfig implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        String className = metadataReader.getClassMetadata().getClassName();
        if (className.equals(CoreMapper.class.getName())){
            return true;
        }
        return false;
    }
}
