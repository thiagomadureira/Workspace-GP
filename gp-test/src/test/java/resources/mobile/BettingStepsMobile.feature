Feature: Navigate to Betting Website

  Scenario: Open BrowserMobile Navigate to William Hill Website
    Given Open ChromeMobile and go to URL
    When Choose Home Team "Slovakia" and Away Team "Malta" on Mobile Device
    And Choose Football Event and Place a Bet "0.05" on Mobile Device
    Then Verify Stakes on Mobile Device