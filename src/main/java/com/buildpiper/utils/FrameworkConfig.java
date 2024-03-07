package com.buildpiper.utils;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Key;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
	    "system:properties",
        "system:env",
		"classpath:project.properties" 
        }
)
public interface FrameworkConfig extends Config {

	@DefaultValue("sandbox")
	String environment();

	@Key("${environment}.username")
	String username();

	@Key("${environment}.password")
	String password();

	@Key("${environment}.url")
	String url();
	
	@Key("${environment}.apibaseurl")
	String apibaseurl();
	
	@Key("${environment}.tag")
	String tag();
	
	@Key("${environment}.gitlabPass")
	String gitlabPass();
	
	@Key("${environment}.gitlabUser")
	String gitlabUser();
	
	@Key("${headless}.Yes")
	String Yes();
	
	@Key("${headless}.No")
	String No();

}
