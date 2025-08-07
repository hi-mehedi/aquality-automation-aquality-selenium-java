package constants;

import lombok.Getter;

@Getter
public enum MainPageNavigation {

    HOME_PAGE("/", NavigationType.PATH),
    NEW_PAGE("/en/us/new-york/10021/weather-forecast/349727", NavigationType.PATH);

    private final String value;
    private final NavigationType type;

    MainPageNavigation(String value, NavigationType type) {
        this.value = value;
        this.type = type;
    }
}
