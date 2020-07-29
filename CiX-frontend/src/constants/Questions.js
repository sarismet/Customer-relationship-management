import newId from '../util/idGenerator';

export const QuestionDescriptions = [{
  text: 'Tek Satırlık Açık Uçlu Soru',
  type: 'SINGLE_LINE_TEXT'
}, {
  text: 'Çok Satırlık Açık Uçlu Soru',
  type: 'MULTI_LINE_TEXT'
}, {
  text: 'Çoktan Seçmeli Soru',
  type: 'MULTI_CHOICE'
}, {
  text: 'Onay Kutucuğu İçeren Soru',
  type: 'CHECKBOXES'
}, {
  text: 'Aşağı Doğru Açılan Soru',
  type: 'DROPDOWN'
}];

export const QuestionTypes = {
  SINGLE_LINE_TEXT: 'SINGLE_LINE_TEXT',
  MULTI_LINE_TEXT: 'MULTI_LINE_TEXT',
  MULTI_CHOICE: 'MULTI_CHOICE',
  CHECKBOXES: 'CHECKBOXES',
  DROPDOWN: 'DROPDOWN'
};

export const InitQuestions = {
  [QuestionTypes.MULTI_CHOICE]: () => ({
    "_id": newId(),
    "type": QuestionTypes.MULTI_CHOICE,
    "title": "Aşağıdaki seçeneklerden birini seçiniz.",
    "options": [
      {
        "_id": newId(),
        "content": "İlk seçenek"
      },
      {
        "_id": newId(),
        "content": "İkinci seçenek"
      },
      {
        "_id": newId(),
        "content": "Üçüncü seçenek"
      }
    ]
  }),
  [QuestionTypes.CHECKBOXES]: () => ({
    "_id": newId(),
    "type": QuestionTypes.CHECKBOXES,
    "title": "Uygun bütün seçenekleri işaretleyin.",
    "options": [
      {
        "_id": newId(),
        "content": "İlk seçenek"
      },
      {
        "_id": newId(),
        "content": "İkinci seçenek"
      },
      {
        "_id": newId(),
        "content": "Üçüncü seçenek"
      }
    ]
  }),
  [QuestionTypes.SINGLE_LINE_TEXT]: () => ({
    "_id": newId(),
    type: QuestionTypes.SINGLE_LINE_TEXT,
    title: 'İsimsiz',
    placeholder: ''
  }),
  [QuestionTypes.MULTI_LINE_TEXT]: () => ({
    "_id": newId(),
    type: QuestionTypes.MULTI_LINE_TEXT,
    title: 'İsimsiz',
    placeholder: ''
  }),
  [QuestionTypes.DROPDOWN]: () => ({
    "_id": newId(),
    "type": QuestionTypes.DROPDOWN,
    "title": "Aşağıdaki seçeneklerden birini seçiniz.",
    "options": [
      {
        "_id": newId(),
        "content": "İlk seçenek"
      },
      {
        "_id": newId(),
        "content": "İkinci seçenek"
      },
      {
        "_id": newId(),
        "content": "Üçüncü seçenek"
      }
    ]
  }),
  'abc': () => ({
    "_id": newId(),
    type: 'MULTI_CHOICE',
    title: 'Evaluate the following statements',
    questions: [
      {
        _id: newId(),
        content: 'First Question'
      },
      {
        _id: newId(),
        content: 'Second Question'
      },
      {
        _id: newId(),
        content: 'Third Question'
      }],
    options: [
      {
        "_id": newId(),
        "content": "First choice"
      },
      {
        "_id": newId(),
        "content": "Second choice"
      },
      {
        "_id": newId(),
        "content": "Third choice"
      }
    ]
  })
};

