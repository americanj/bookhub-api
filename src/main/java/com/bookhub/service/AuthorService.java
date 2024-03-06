package com.bookhub.service;

import com.bookhub.domain.mapper.AuthorMapper;
import com.bookhub.domain.model.AuthorModel;
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
    public AuthorModel createAuthor(AuthorVo authorVo) {
        AuthorModel authorModel = authorMapper.voToModel(authorVo);
        return authorRepository.save(authorModel);
    }

    public AuthorModel updateAuthor(AuthorVo authorVo, Long authorId) {
        authorRepository.findByIdOrThrowException(authorId);
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