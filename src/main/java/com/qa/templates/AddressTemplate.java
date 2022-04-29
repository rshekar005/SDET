package com.qa.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.qa.fixtures.Address;

public class AddressTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(Address.class).addTemplate("valid", new Rule() {
            {
               add("city",random("Hyderabad","Warangal"));
               add("state",random("Telangana","AP"));
            }
        });

        Fixture.of(Address.class).addTemplate("inValid", new Rule() {
            {
                add("city",random("",null));
                add("state",random("",null));
            }
        });


    }
}
