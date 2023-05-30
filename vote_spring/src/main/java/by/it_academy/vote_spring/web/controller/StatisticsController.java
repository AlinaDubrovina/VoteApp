package by.it_academy.vote_spring.web.controller;

import by.it_academy.vote_spring.core.dto.StatisticsDTO;
import by.it_academy.vote_spring.service.api.IStatisticsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    private final IStatisticsService statisticsService;

    public StatisticsController(IStatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public StatisticsDTO getStatistics() {
        return statisticsService.getStatistics();
    }
}
