package com.gdu.app007;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.gdu.app007.config.BoardAppContext;
import com.gdu.app007.domain.BoardDTO;
import com.gdu.app007.repository.BoardDAO;

// JUnit4를 사용한다. (6장과 동일한 코드를 사용하면 실패(이유: context.xml을 읽지 못하기 때문(context.xml은 톰캣이 읽어 드리는데, JUnit Test는 톰캣을 사용하지 않으므로))
// 커스터마이징한 MySpringJUnit4ClassRunner를 사용한다.
@RunWith(MySpringJUnit4ClassRunner.class)

// Bean은 BoardAppContext에 정의되어 있다.
@ContextConfiguration(classes= {BoardAppContext.class})

public class BoardUnitTest {

	@Autowired
	private BoardDAO dao;
	
	@Test
	public void 삽입테스트() {
		BoardDTO board = new BoardDTO(0, "테스트제목", "테스트내용", "테스트작성자", null, null);
		assertEquals(1, dao.insertBoard(board));	
	}	// insert 결과로 1이 나오길 기대
	
	
	
	
}
