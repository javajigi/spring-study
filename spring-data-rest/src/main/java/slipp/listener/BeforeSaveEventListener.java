package slipp.listener;

import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

import slipp.domain.Person;

@Component
public class BeforeSaveEventListener extends AbstractRepositoryEventListener<Person> {
	@Override
	protected void onBeforeSave(Person entity) {
		System.out.println("Before save : " + entity);
	}
	
	@Override
	protected void onAfterDelete(Person entity) {
		System.out.println("After delete : " + entity);
	}
}
