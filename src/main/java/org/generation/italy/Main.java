package org.generation.italy;

import org.generation.italy.model.data.abstractions.DeveloperRepository;
import org.generation.italy.model.data.implementations.InMemoryDeveloperRepository;
import org.generation.italy.model.services.implementations.SoftwareDevelopService;
import org.generation.italy.model.view.UserInterfaceConsole;

public class Main {
    public static void main(String[] args) {
        new UserInterfaceConsole(new SoftwareDevelopService(new InMemoryDeveloperRepository())).userInteraction();
    }
}