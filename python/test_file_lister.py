import unittest
from unittest.mock import patch, MagicMock
import os
from file_lister import FileLister
from file_filter import FileFilter

class TestFileLister(unittest.TestCase):

    def setUp(self):
        self.test_folder_path = "test_folder"
        self.file_filter_mock = MagicMock(spec=FileFilter)
        self.file_lister = FileLister(self.test_folder_path)
        self.file_lister.file_filter = self.file_filter_mock

    @patch('os.path.isfile')
    @patch('os.path.exists')
    @patch('os.path.isdir')
    @patch('os.listdir')
    def test_list_files(self, mock_listdir, mock_isdir, mock_exists, mock_isfile):
        mock_isfile.return_value = True
        mock_exists.return_value = True
        mock_isdir.return_value = True
        mock_listdir.return_value = ['file1.txt', 'file2.doc', 'example.txt', 'example.doc']

        file_list = self.file_lister.list_files()

        self.assertEqual(4, len(file_list))
        self.assertIn('file1.txt', file_list)
        self.assertIn('file2.doc', file_list)
        self.assertIn('example.txt', file_list)
        self.assertIn('example.doc', file_list)

    @patch('os.path.isfile')
    @patch('os.path.exists')
    @patch('os.path.isdir')
    @patch('os.listdir')
    def test_list_files_with_filter_by_extension(self, mock_listdir, mock_isdir, mock_exists, mock_isfile):
        mock_exists.return_value = True
        mock_isdir.return_value = True
        mock_listdir.return_value = ['file1.txt', 'file2.doc', 'example.txt', 'example.doc']

        filtered_by_extension = ['file1.txt', 'example.txt']
        self.file_filter_mock.filter_by_extension.return_value = filtered_by_extension

        file_list = self.file_lister.list_files_with_filter(extension=".txt")

        self.assertEqual(2, len(file_list))
        self.assertIn('file1.txt', file_list)
        self.assertIn('example.txt', file_list)

        self.file_filter_mock.filter_by_extension.assert_called_once_with(mock_listdir.return_value, ".txt")
        self.file_filter_mock.filter_by_keyword.assert_not_called()

    @patch('os.path.isfile')
    @patch('os.path.exists')
    @patch('os.path.isdir')
    @patch('os.listdir')
    def test_list_files_with_filter_by_keyword(self, mock_listdir, mock_isdir, mock_exists, mock_isfile):
        mock_exists.return_value = True
        mock_isdir.return_value = True
        mock_listdir.return_value = ['file1.txt', 'file2.doc', 'example.txt', 'example.doc']

        filtered_by_keyword = ['example.txt', 'example.doc']
        self.file_filter_mock.filter_by_keyword.return_value = filtered_by_keyword

        file_list = self.file_lister.list_files_with_filter(keyword="example")

        self.assertEqual(2, len(file_list))
        self.assertIn('example.txt', file_list)
        self.assertIn('example.doc', file_list)

        self.file_filter_mock.filter_by_extension.assert_not_called()
        self.file_filter_mock.filter_by_keyword.assert_called_once_with(mock_listdir.return_value, "example")

    @patch('os.path.isfile')
    @patch('os.path.exists')
    @patch('os.path.isdir')
    @patch('os.listdir')
    def test_list_files_with_filter_by_extension_and_keyword(self, mock_listdir, mock_isdir, mock_exists, mock_isfile):
        mock_exists.return_value = True
        mock_isdir.return_value = True
        mock_listdir.return_value = ['file1.txt', 'file2.doc', 'example.txt', 'example.doc']

        filtered_by_extension = ['file1.txt', 'example.txt']
        self.file_filter_mock.filter_by_extension.return_value = filtered_by_extension

        filtered_by_keyword = ['example.txt']
        self.file_filter_mock.filter_by_keyword.return_value = filtered_by_keyword

        file_list = self.file_lister.list_files_with_filter(extension=".txt", keyword="example")

        self.assertEqual(1, len(file_list))
        self.assertIn('example.txt', file_list)

        self.file_filter_mock.filter_by_extension.assert_called_once_with(mock_listdir.return_value, ".txt")
        self.file_filter_mock.filter_by_keyword.assert_called_once_with(filtered_by_extension, "example")

if __name__ == '__main__':
    unittest.main()
