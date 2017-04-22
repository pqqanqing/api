package com.wjs.api.swagger.builder;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

public class DocketBuilder {
    private String title;
    private String version;
    private String group;

    private String contactName;
    private String url;
    private String email;

    private String[] paths;

    private DocketBuilder() {
    }

    public static DocketBuilder title(String title) {
        DocketBuilder builder = new DocketBuilder();
        builder.title = title;

        return builder;
    }

    public DocketBuilder version(String version) {
        this.version = version;

        return this;
    }

    public DocketBuilder group(String group) {
        this.group = group;

        return this;
    }

    public DocketBuilder contact(String contact, String url, String email) {
        this.contactName = contact;
        this.url = url;
        this.email = email;

        return this;
    }

    public DocketBuilder paths(String... paths) {
        this.paths = paths;

        return this;
    }

    public Docket build() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(group)
                .apiInfo(info())
                .select()
                .paths(paths())
                .build();
    }

    private ApiInfo info() {
        return new ApiInfoBuilder()
                .title(title)
                .contact(new Contact(contactName, url, email))
                .version(version)
                .build();
    }

    private Predicate<String> paths() {
        List<Predicate<String>> predicates = Lists.newArrayList();
        for (String path : paths) {
            predicates.add(PathSelectors.regex(path));
        }
        return Predicates.or(predicates);
    }
}
