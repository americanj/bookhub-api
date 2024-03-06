package com.bookhub.service;

import com.bookhub.domain.mapper.AuthorMapper;
import com.bookhub.domain.model.AuthorModel;
import com.bookhub.domain.request.AuthorRequest;
import com.bookhub.domain.vo.AuthorVo;
import com.bookhub.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    @Transactional
    public AuthorVo createAuthor(AuthorVo authorVo) {
        AuthorModel authorModel = authorMapper.voToModel(authorVo);
        return authorMapper.modelToVo(authorRepository.save(authorModel));
    }

    public AuthorVo updateAuthor(Long authorId, AuthorRequest authorRequest) {
        authorRepository.findByIdOrThrowException(authorId);
        AuthorVo authorVo = authorMapper.resquestToVo(authorRequest, authorId);
        return createAuthor(authorVo);
    }

    public AuthorVo getAuthor(Long authorId) {
        AuthorModel authorModel = authorRepository.findByIdOrThrowException(authorId);
        return authorMapper.modelToVo(authorModel);
    }

    public List<AuthorVo> getAuthors() {
        List<AuthorModel> authorModels = authorRepository.findAll();
        return authorMapper.modelsToVos(authorModels);

    }

    @Transactional
    public void deleteAuthor(Long authorId) {
        AuthorModel authorModel = authorRepository.findByIdOrThrowException(authorId);
        authorRepository.delete(authorModel);
    }
}