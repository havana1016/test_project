package com.its.member.service;

import com.its.member.dto.BoardDTO;
import com.its.member.entity.BoardEntity;
import com.its.member.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository br;

    public Long save(BoardDTO boardDTO) {
        return br.save(BoardEntity.toSaveEntity(boardDTO)).getId();
    }

    public BoardDTO findById(Long id) {
        if (br.findById(id).isPresent()) {
            return BoardDTO.toBoardDTO(br.findById(id).get());
        } else {
            return null;
        }
    }

    public List<BoardDTO> findAll() {
        List<BoardEntity> boardEntityList = br.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for (BoardEntity b: boardEntityList) {
            boardDTOList.add(BoardDTO.toBoardDTO(b));
        }
        return boardDTOList;
    }
}
