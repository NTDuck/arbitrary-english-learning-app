package org.tomfoolery.core.usecases.dictionaries;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.tomfoolery.core.dataproviders.DictionaryRepository;
import org.tomfoolery.core.usecases.utils.functional.ThrowableFunction;
import org.tomfoolery.core.usecases.utils.requests.UpdateDictionaryRequest;
import org.tomfoolery.core.usecases.utils.responses.UpdateDictionaryResponse;

@RequiredArgsConstructor(staticName = "of")
public class UpdateDictionaryUseCase implements ThrowableFunction<UpdateDictionaryRequest, UpdateDictionaryResponse> {
    @NonNull private final DictionaryRepository repository;

    @Override
    public UpdateDictionaryResponse apply(UpdateDictionaryRequest request) throws NotFoundException {
        val dictionary = request.getDictionary();

        if (!this.repository.contains(dictionary.getId()))
            throw new NotFoundException();

        this.repository.save(dictionary);
        return UpdateDictionaryResponse.of(dictionary.getId());
    }

    public static class NotFoundException extends Exception {}
}
